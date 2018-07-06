def length[A](as: List[A]): Int =
  foldRight(as, 0)((_,z) => z + 1)
