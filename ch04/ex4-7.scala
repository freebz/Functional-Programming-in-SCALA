def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = es match {
  case Nil => Right(Nil)
  case h :: t => h flatMap (hh => sequence(t) map (hh :: _))
}

def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] =
  traverse(es)(x => x)

def traverse[E, A, B](as: List[A])(
  f: A => Either[E, B]): Either[E, List[B]] =
  this match {
    case Nil => Right(Nil)
    case h :: t => (f(h) map2 traverse(t)(f))(_ :: _)
  }

def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
  es.foldRight[Either[E, List[B]]](Right(Nil))((a, b) => f(a).map2(b)(_ :: _))
