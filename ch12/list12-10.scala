// 목록 12.10 순회 가능 함수자를 목록으로 변환

def toList[A](fa: F[A]): List[A] =
  traverseS(fa)((a: A) => (for {
    as <- get[List[A]]
    _ <- set(a :: as)
  } yield ()).run(Nil)._2.reverse
