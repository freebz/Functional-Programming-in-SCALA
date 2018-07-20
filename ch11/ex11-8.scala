def flatMap[A, B](a: A)(f: A => F[B]): F[B] =
  compose((_:Unit) => ma, f)(())
