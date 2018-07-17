def unit[A](a: A): Gen[A] =
  Gen(State.unit(a))

def boolean: Gen[Boolean] =
  Gen(State(RNG.boolean))

def listOfN[A](n: Int, a: Gen[A]): Gen[List[A]] =
  Gen(State.sequence(List.fill(n)(a.sample)))
