// 목록 15.6 runLog 함수

def runLog[O](src: Process[IO,O]): IO[IndexedSeq[O]] = IO {
  val E = java.util.concurrent.Executors.newFixedThreadPool(4)
  @annotation.tailrec
  def go(cur: Process[IO,O], acc: IndexedSeq[O]): IndexedSeq[O] =
    cur match {
      case Emit(h,t) => go(t, acc :+ h)
      case Halt(End) => acc
      case Halt(err) => throw err
      case Await(req,recv) =>
        val next =
          try recv(RIght(unsafePerformIO(req)(E)))
          catch { case err: Throwable => recv(Left(err)) }
        go(next, acc)
    }
  try go(src, IndexedSeq())
  finally E.shutdown
}
