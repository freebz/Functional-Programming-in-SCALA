// 목록 15.7 형식 추론 보조 함수들

def await1[I,O](
    recv: I => Process1[I,O],
    fallback: Process1[I,O] = halt1[I,O]): Process1[I, O] =
  Await(Get[I], (e: Either[Throwable,I]) => e match {
    case Left(End) => fallback
    case Left(err) => Halt(err)
    case Right(i) => Try(recv(i))
  })

def emit1[I,O](h: O, tl: Process1[I,O] = halt1[I,O]): Process1[I,O] =
  emit(h, tl)

def halt1[I,O]: Process1[I,O] = Halt[Is[I]#f, O](End)
