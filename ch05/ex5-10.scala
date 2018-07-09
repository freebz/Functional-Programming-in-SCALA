def fibs(): Stream[Int] = {
  def fibs(a: Int, b: Int): Stream[Int] =
    cons(a, fibs(b, a + b))
  fibs(0, 1)
}
