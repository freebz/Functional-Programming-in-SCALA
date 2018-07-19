val intAddition: Monoid[Int] = new Monoid[Int] {
  def op(a1: Int, a2: Int): Int = a1 + a2
  def zero: Int = 0
}

val intMultiplication: Monid[Int] = new Monoid[Int] {
  def op(a1: Int, a2: Int): Int = a1 * a2
  def zero: Int = 1
}

val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
  def op(a1: Boolean, a2: Boolean): Boolean = a1 || a2
  def zero: Boolean = false
}

val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
  def op(a1: Boolean, a2: Boolean): Boolean = a1 && a2
  def zero: Boolean = true
}
