def startsWith[A](s: Stream[A]): Boolean = (this, s) match {
  case (Cons(h1, t1), Cons(h2, t2)) if h1() == h2() => t1() startsWith t2()
  case (Cons(h, t), Empty) => true
  case _ => false
}


def startsWith[A](s: Stream[A]): Boolean =
  zipAll(s).takeWhile(!_._2.isEmpty) forAll {
    case (h1, h2) => h1 == h2
  }
