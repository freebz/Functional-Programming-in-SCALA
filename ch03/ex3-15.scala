def concat[A](l: List[List[A]]): List[A] =
  foldRight(l, Nil:List[A])(append)
