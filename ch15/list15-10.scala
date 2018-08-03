// 목록 15.10 tee 함수

def tee[O2,O3](p2: Process[F,O2])(t: Tee[O,O2,O3]): Process[F,O3] =

  t match {

    case Halt(e) => this.kill onComplete p2.kill onComplete Halt(e)

    case Emit(h,t) => Emit(h, (this tee p2)(t))

    case Await(side, recv) => side.get match {

      case Left(isO) => this match {

        case Halt(e) => p2.kill onComplete Halt(e)

        case Emit(o,ot) => (ot tee p2)(Try(recv(Right(o))))

        case Await(reqL, recvL) =>

          await(reqL)(recvL andThen (this2 => this2.tee(p2)(t)))

      }


      case Right(isO2) => p2 match {

        case Halt(e) => this.kill onComplete Halt(e)

        case Emit(o2,ot) => (this tee ot)(Try(recv(Right(o2))))

        case Await(reqR, recvR) =>

          await(reqR)(recvR andThen (p3 => this.tee(p3)(t)))

      }
    }
  }
