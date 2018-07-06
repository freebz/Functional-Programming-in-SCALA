def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
  case Nil => Some(Nil)
  case h :: t => h flatMap (hh => sequence(t) map (hh :: _))
}


def sequence[A](a: List[Option[A]]): Option[List[A]] =
  a.foldRight[Option[List[A]]](Some(Nil))((x,y) => map2(x,y)(_ :: _))
