def tails: Stream[Stream[A]] =
  unfold(this) {
    case Cons(h, t) => Some((this, t))
    case _ => None
  } append Stream(empty)



def tails: Strem[Stream[A]] =
  unfold(this) {
    case Empty => None
    case s => Some((s, s drop 1))
  } append Stream(empty)
