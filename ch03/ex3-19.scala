def filter[A](as: List[A])(f: A => Boolean): List[A] =
  foldRight(as, Nil:List[A])((a, b) => if (f(a)) Cons(a, b) else b)


def even(ns: List[Int]): List[Int] =
  filter(ns)(_ % 2 == 0)
