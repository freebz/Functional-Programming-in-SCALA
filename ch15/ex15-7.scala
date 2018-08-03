def zip[A,B,C](p1: Process[A,B], p2: Process[A,C]): Process[A,(B,C)] =
  (p1, p2) match {
    case (Halt(), _) => Halt()
    case (_, Halt()) => Halt()
    case (Emit(b, t1), Emit(c, t2)) => Emit((b,c), zip(t1, t2))
    case (Await(recv1), _) =>
      Await((oa: Option[A]) => zip(recv1(oa), feed(oa)(p2)))
    case (_, Await(recv2)) =>
      Await((oa: Option[A]) => zip(feed(oa)(p1), recv2(oa)))
  }

def feed[A,B](oa: Option[A])(p: Process[A,B]): Process[A,B] =
  p match {
    case Halt() => p
    case Emit(h,t) => Emit(h, feed(oa)(t))
    case Await(recv) => recv(oa)
  }
