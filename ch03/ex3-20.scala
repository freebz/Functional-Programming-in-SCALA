def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] =
  concat(map(as)(f))
