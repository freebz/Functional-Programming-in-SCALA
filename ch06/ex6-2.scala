def double(rng: RNG): (Double, RNG) = {
  val (n1, rng1) = nonNegativeInt(rng)
  (n1 / (Int.MaxValue.toDouble + 1), rng1)
}
