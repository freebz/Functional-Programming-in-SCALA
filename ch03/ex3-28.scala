def map[A,B](t: Tree[A])(f: A => B): Tree[B] = t match {
  case Leap(a) => Leap(f(a))
  case Branch(l, r) => Branch(map(l)(f), map(r)(f))
}
