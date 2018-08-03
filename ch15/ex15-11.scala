def eval[F[_],A](a: F[A]): Process[F,A] =
  await[F,A,A](a) {
    case Left(err) => Halt(err)
    case Right(a) => Emit(a, Halt(End))
  }

def eval_[F[_],A,B])(a: F[A]): Process[F,B] =
  eval[F,A](a).drain[B]
