def setHead[A](as: List[A], a: A): List[A] = as match {
  case Cons(_, xs) => Cons(a, xs)
  case Nil => Nil
}
