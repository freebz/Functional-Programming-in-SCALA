def drop[A](l: List[A], n: Int): List[A] =
  if (n > 0) drop(tail(l), n - 1)
  else l


def drop[A](l: List[A], n: Int): List[A] = l match {
  case Cons(x, xs) if n > 0 => drop(xs, n - 1)
  case Nil => Nil
  case _ => l
}
