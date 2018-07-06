def zipWith[A,B,C](a: List[A], b: List[B])(f: (A, B) => C): List[C] = (a, b) match {
  case (Nil, _) => Nil
  case (_, Nil) => Nil
  case (Cons(a,as), Cons(b,bs)) => Cons(f(a,b), zipWith(as, bs)(f))
}
