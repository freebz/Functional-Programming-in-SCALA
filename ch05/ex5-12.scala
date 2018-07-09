def fibs(): Stream[Int] =
  unfold((0, 1))((a, b) => Some((a, (b, a + b))))

def from(n: Int): Stream[Int] =
  unfold(n)(n => Some((n, n + 1)))   

def constant[A](a: A): Stream[A] =
  unfold(a)(_ => Some((a, a)))

def ones: Stream[Int] =
  unfold(1)(_ => Some((1, 1)))
