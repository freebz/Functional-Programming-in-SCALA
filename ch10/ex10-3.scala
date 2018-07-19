def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
  def op(f: A => A, g: A => A): A => A = f compose g
  def zero = (a: A) => a
}
