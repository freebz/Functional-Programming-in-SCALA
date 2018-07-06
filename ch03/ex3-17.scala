def doubleToString(ds: List[Double]): List[String] =
  foldRight(ds, Nil:List[String])(Cons(_.toString, _))
