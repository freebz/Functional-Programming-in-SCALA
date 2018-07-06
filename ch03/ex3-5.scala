def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
  case Cons(x, xs) if f(x) => dropWhile(xs, f)
  case _ => l
}
