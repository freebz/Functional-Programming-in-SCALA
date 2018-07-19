def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
  foldMap(as, dual(endoMonoid[B]))(a => b => f(b, a))(z)

def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
  foldMap(as, endoMonoid[B])(f.curried)(z)
