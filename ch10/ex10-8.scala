import fpinscala.parallelism.Nonblocking._

def par[A](m: Monoid[A]): Monoid[Par[A]] = new Monoid[Par[A]] {
  def op(a1: Par[A], a2: Par[A]): Par[A] = a1.map2(a2)(m.op)
  def zero: => Par.unit(m.zero)
}

def parFoldMap[A,B](v: IndexedSeq[A], m: Monoid[B])(f: A => B): Par[B] =
  Par.parMap(v)(f).flatMap { bs =>
    foldMapV(bs, par(m))(b => Par.async(b))
  }
