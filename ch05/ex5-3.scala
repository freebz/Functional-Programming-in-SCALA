def takeWhile(f: A => Boolean): Stream[A] = this match {
  case Cons(h, t) if f(h()) => cons(h(), t() takeWhile f)
  case _ => empty
}
