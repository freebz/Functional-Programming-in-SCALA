// 목록 11.2 map2를 위한 Mon 특질의 정의

trait Mon[F[_]] {
  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
    fa flatMap (a => fb map (b => f(a, b)))
}
