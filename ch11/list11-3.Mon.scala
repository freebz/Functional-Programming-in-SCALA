// 목록 11.3 map과 flatMap을 Mon 특질에 추가

trait Mon[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
    fa flatMap (a => fb map (b => f(a, b)))
}
