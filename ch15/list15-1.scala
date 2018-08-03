// 목록 15.1 명령식으로 파일 행 수 세기

def linesGt40k(filename: String): IO[Boolean] = IO {
  val src = io.Slurce.fromFile(filename)
  try {
    var count = 0
    val lines: Iterator[String] = src.getLines
    while (count <= 40000 && lines.hasNext) {
      lines.next
      count += 1
    }
    count > 40000
  }
  finally src.close
}
