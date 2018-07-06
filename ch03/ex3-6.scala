def init[A](l: List[A]): List[A] = l match {
  case Cons(_, Nil) => Nil
  case Cons(x, xs) => Cons(x, init(xs))
  case Nil => Nil
}
