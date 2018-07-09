def forAll(p: A => Boolean): Boolean =
  foldRight(true)((a, b) => p(a) && b)
