// 목록 15.5 onHalt 함수와 ++ 함수

def onHalt(f: Throwable => Process[F,O]): Process[F,O] = this match {
  case Halt(e) => Try(f(e))
  case Emit(h, t) => Emit(h, t.onHalt(f))
  case Await(req, recv) => Await(req, recv and Then (_.onHalt(f)))
}

def ++(p: => Process[F,O]): Process[F,O] =
  this.onHalt {
    case End => p
    case err => Halt(err)
  }
