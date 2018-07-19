def foldMapV[A,B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): B = v.length match {
  case 0 => m.zero
  case 1 => f(v(0))
  case n =>
    val (l, r) = v.splitAt(n / 2)
    m.op(foldMapV(l, m)(f), foldMapV(r, m)(f))
}
