// 목록 13.3 doWhile 루프를 가진 명령식 프로그램

def factorial(n: Int): IO[Int] = for {
  acc <- ref(1)
  _ <- foreachM (1 to n toStream) (i => acc.modify(_ * i).skip)
  result <- acc.get
} yield result

val factorialREPL: IO[Unit] = sequence_(
  IO { println(helpstring) },
  doWhile { IO { readLine } } { line =>
    when (line != "q") { for {
      n <- factorial(line.toInt)
      _ <- IO { println("factorial: " + n) }
    } yield () }
  })
