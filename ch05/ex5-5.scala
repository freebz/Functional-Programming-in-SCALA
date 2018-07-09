def takeWhile(p: A => Boolean): Stream[A] =
  foldRight(empty)((a, b) =>
    if (p(a)) cons(a, b)
    else empty)
