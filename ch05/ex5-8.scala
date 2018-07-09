def constant[A](a: A): Stream[A] =
  cons(a, constant(a))


def contant[A](a: A): Stream[A] = {
  lazy val tail: Stream[A] = Cons(() => a, () => tail)
  tail
}
