def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B =
  foldRight(reverse(as), z)(f)

def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
  foldLeft(reverse(as), z)((b,a) => f(a,b))



def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B =
  foldRight(as, (b:B) => b)((a,g) => b => g(f(b,a)))(z)

def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
  foldLeft(as, (b:B) => b)((g,a) => b => g(f(a,b)))(z)

