def flatMap[A, B](a: F[A])(f: A => F[B]): F[B] =
  join(map(a)(f))


def compose[A, B, C](f: A => F[B], g: B => F[C]): A => F[C] =
  a => join(map(f(a))(g))
