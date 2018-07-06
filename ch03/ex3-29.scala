def fold[A,B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
  case Leaf(a) => f(a)
  case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
}

def size[A](t: Tree[A]): Int =
  fold(t)(_ => 1)(_ + _ + 1)

def maximun(t: Tree[Int]): Int =
  fold(t)(_ => _)(_ max _)

def depth[A](t: Tree[A]): Int =
  fold(t)(_ => 0)((_ max _) + 1)

def map[A,B](t: Tree[A])(f: A => B): Tree[B] =
  fold(t)(Leaf(f(_)))(Branch(_, _))
