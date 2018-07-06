def map[A,B](as: List[A])(f: A => B): List[B] =
  foldRight(as, Nil:List[B])(Cons(f(_), _))
