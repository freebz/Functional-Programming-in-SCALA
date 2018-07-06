def tail[A](as: List[A]): List[A] = as match {
  case Cons(_, xs) => xs
  case Nil => Nil
}
