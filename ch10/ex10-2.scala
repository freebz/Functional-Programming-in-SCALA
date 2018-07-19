def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Motopn[A]] {
  def op(a1: Option[A], a2: Option[A]): Option[A] = a1 orElse a2
  def zero: Option[A] = None
}
