def sum(ns: List[Int]) =
  foldLeft(ns, 0)(_ + _)

def product(ds: List[Double]) =
  foldLeft(ds, 1.0)(_ * _)

def length[A](as: List[A]): Int =
  foldLeft(as, 0)((z, _) => z + 1)
