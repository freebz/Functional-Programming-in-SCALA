// 목록 15.3 스트림 대신 파일로 Process를 구동

def processFile[A,B](f: java.io.File,
                     p: Process[String, A],
                     z: B)(g: (B, A) => B): IO[B] = IO {
  @annotation.tailrec
  def go(ss: Iterator[String], cur: Process[String, A], acc: B): B =
    cur match {
      case Halt() => acc
      case Await =>
        val next = if (ss.hasNext) recv(Some(ss.next))
                   else recv(None)
        go(ss, next, acc)
      case Emit(h, t) => go(ss, t, g(acc, h))
    }
  val s = io.Source.fromFile(f)
  try go(s.getLines, p, z)
  finally s.close
}
