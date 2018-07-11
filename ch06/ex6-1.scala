def nonNegativeInt(rng: RNG): (Int, RNG) = {
  val (n1, rng1) = rng.nextInt
  if (n1 < 0) nonNegativeInt(rng1)
  else (n1, rng1)
}


def nonNegativeInt(rng: RNG): (Int, RNG) = {
  val (i, r) = rng.nextInt
  (if (i < 0) -(i + 1) else i, r)
}
