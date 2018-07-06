def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
  sequence(a map f)

def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
  case Nil => Some(Nil)
  case h :: t => map2(f(h), traverse(t)(f))(_ :: _)
}

def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
  a.foldRight[Option[List[B]](Some(Nil))(x,y) => map2(f(x),y)(_ :: _))


def sequence[A](a: List[Option[A]]): Option[List[A]] =
  traverse(a)(a => a)
