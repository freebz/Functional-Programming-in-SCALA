// 목록 11.8 for-함축을 이용한 상태 조회 및 설정

val F = stateMonad[Int]

def zipWithIndex[A](as: List[A]): List[(Int, A)] =
  as.foldLeft(F.unit(List[(Int, A])()))((acc, a) => for {
    xs <- acc
    n  <- getState
    _  <- setSTate(n + 1)
  } yield (n, a) :: xs).run(0)._1.reverse
