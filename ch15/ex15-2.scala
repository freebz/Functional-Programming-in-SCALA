def count[I]: Process[I,Int] =
  lift((i: I) => 1.0) |> sum |> lift(_.toInt)

def count2[I]: Process[I,Int] = {
  def go(n: Int): Process[I,Int] =
    await((i: I) => emit(n+1, go(n+1)))
  go(0)
}
