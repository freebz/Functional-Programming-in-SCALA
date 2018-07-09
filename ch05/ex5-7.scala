def map[B](f: A => B): Stream[B] =
  foldRight(empty[B])((a, b) => cons(f(a), b))

def filter(p: A => Boolean): Stream[A] =
  foldRight(empty[A])((a, b) => if (p(a)) cons(a, b) else b)

def append[B>:A](s: Stream[B]): Stream[B] =
  foldRight(s)((a, b) => cons(a, b))

def flatMap[B](f: A => Stream[B]): Stream[B] =
  foldRight(empty[B])((a, b) => f(a) append b)
