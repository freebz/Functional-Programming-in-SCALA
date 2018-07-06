def add1(ns: List[Int]): List[Int] =
  foldRight(ns, Nil:List[Int])(Cons(_ + 1, _))
