def map[B](f: A => B): Stream[B] =
  unfold(this) {
    case Cons(h, t) => Some((f(h()), t()))
    case _ => None
  }

def take(n: Int): Stream[A] =
  unfold((this, n)) {
    case (Cons(h, t), 1)  => Some((h(), (empty, 0)))
    case (Cons(h, t), n)  if n > 1 => Some((h(), (t(), n - 1)))
    case _ => None
  }

def takeWhile(p: A => Boolean): Stream[A] =
  unfold(this) {
    case Cons(h, t) if p(h()) => Some((h(), t()))
    case _ => None
  }

def zipWith[B,C](s2: Stream[B])(f: (A,B) => C): Stream[C] =
  unfold((this, s2)) {
    case (Cons(h1, t1), Cons(h2, t2)) => Some((f(h1(), h2()), (t1(), t2())))
    case _ => None
  }

def zipAll[B](s2: Stream[B]): Stream[(Option[A],Option[B])] =
  unfold((this, s2)) {
    case (Cons(h1, t1), Cons(h2, t2)) => Some(((Some(h1()), Some(h2())), (t1(), t2())))
    case (Cons(h, t), _) => Some(((Some(h()), None), (t(), empty)))
    case (_, Cons(h, t)) => Some(((None, Some(h())), (empty, t())))
    case _ => None
  }
