def addPairwise(a: List[Int], b: List[Int]): List[Int] = (a, b) match {
  case (Nil, _) => Nil
  case (_, Nil) => Nil
  case (Cons(x, xs), Cons(y, ys)) => Cons(x + y, addPairwise(xs, ys))
}
