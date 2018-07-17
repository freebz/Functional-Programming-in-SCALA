def choose(start: Int, stopExclusive: Int): Gen[Int] = {
  Gen(State(rng => {
    val (n, r1) = RNG.nonNegativeLessThan(stopExclusive - start)
    (n + start, r1)
  }))
}


def choose(start: Int, stopExclusive: Int): Gen[Int] =
  Gen(State(RNG.nonNegativeInt).map(n => start + n % (stopExclusive-start)))
