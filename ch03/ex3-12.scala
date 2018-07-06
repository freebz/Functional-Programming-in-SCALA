def reverse[A](as: List[A]): List[A] = {
  def loop(as: List[A], acc: List[A]): List[A] = as match {
    case Cons(x, xs) => loop(xs, Cons(x, acc))
    case Nil => acc
  }

  loop(as, [])
}


def reverse[A](as: List[A]): List[A] =
  foldLeft(as, List[A]())((acc, a) => Cons(a, acc))
