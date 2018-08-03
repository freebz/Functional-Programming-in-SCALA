trait Process[F[_],O] {
  def runLog(implicit F: MonadCatch[F]): F[IndexedSeq[O]] =
    def go(cur: Process[F,O], acc: IndexedSeq[O]): F[IndexedSeq[O]] =
      cur match {
        case Emit(h,t) => go(t, acc :+ h)
        case Halt(End) => F.unit(acc)
        case Halt(err) => F.fail(err)
        case Await(req,recv) => F.flatMap (F.attempt(req)) { e => go(Try(recv(e)), acc) }
      }
  go(this, IndexedSeq())
}

trait MonadCatch[F[_]] extends Monad[F] {
  def attempt[A](a: F[A]): F[Either[Throwalbe,A]]
  def fail[A](t: Throwable): F[A]
}
