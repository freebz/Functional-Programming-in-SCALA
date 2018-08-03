// 목록 15.2 Process 자료 형식

sealed trait Process[I,O]

case class Emit[I,O](
  head: O,
  tail: Process[I,O] = Halt[I,O]())
    extends Process[I,O]
case class Await[I,O](
  recv: Option[I] => Process[I,O])
    extends Process[I,P]

case class Halt[I,O]() extends Process[I,O]
