// 목록 12.9 순회 가능한 자료구조 안의 요소들에 번호 매기기

def zipWithIndex[A](ta: F[A]): F[(A,Int)] =
  traverseS(ta)((a: A) => (for {
    i <- get[Int]
    _ <- set(i + 1)
  } yield (a, i))).run(0)._1
