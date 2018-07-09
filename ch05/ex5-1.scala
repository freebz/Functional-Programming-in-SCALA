def toList: List[A] = this match {
  case Cons(h, t) => h() :: t().toList
  case _ => List()
}
