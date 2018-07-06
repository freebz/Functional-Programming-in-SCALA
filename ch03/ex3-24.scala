@annotation.tailrec
def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
  @annotation.tailrec
  def startsWith[A](as: List[A], prefix: List[A]): Boolean = (as, prefix) match {
    case (_, Nil) => true
    case (Cons(a,as), Cons(p,ps)) if a == p => startsWith(as, ps)
    case _ => false
  }

  sup match {
    case Nil => sub == Nil
    case _ if startsWith(sup, sub) => true
    case Cons(_,as) => hasSubsequence(as, sub)
  }
}
