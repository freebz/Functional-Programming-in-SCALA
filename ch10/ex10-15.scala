def toList[A](fa: F[A]): List[A] =
  foldRight(fa)(List[A]())(_ :: _)
