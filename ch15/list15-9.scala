// 목록 15.9 Tee의 입력들을 위한 편의용 함수들

def haltT[I,I2,O]: Tee[I,I2,O] =
  Halt[T[I,I2]#f,O](End)

def await[I,I2,O](
    recv: I => Tee[I,I2,O],
    fallback: => Tee[I,I2,O] = haltT[I,I2,O]): Tee[I,I2,O] =
  await[T[I,I2]#f,I,O](L) {
    case Left(End) => fallback
    case Left(err) => Halt(err)
    case Right(a) => Try(recv(a))
  }

def awaitR[I,I2,O](
    recv: I2 => Tee[I,I2,O],
    fallback: => Tee[I,I2,O] = haltT[I,I2,O]): Tee[I,I2,O] =
  await[T[I,I2]#f,I2,O](R) {
    case Left(End) => fallback
    case Left(err) => Halt(err)
    case Right(a) => Try(recv(a))
  }

def emitT[I,I2,O](h: O, tl: Tee[I,I2,O] = haltT[I,I2,O]): Tee[I,I2,O] =
  emit(h, tl)
