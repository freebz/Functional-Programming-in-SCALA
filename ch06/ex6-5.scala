def double(rng: RNG): (Double, RNG) =
  map(nonNegativeInt)(_ / (Int.MaxValue.toDouble + 1))
