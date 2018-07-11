def intDouble(rng: RNG): ((Int,Double), RNG) = {
  val (i1, rng1) = rng.nextInt
  val (d2, rng2) = double(rng1)
  ((i1, d2), rng2)
}

def doubleInt(rng: RNG): ((Double,Int), RNG) = {
  val ((i, d), r) = intDouble(rng)
  ((d, i), r)
}

def double3(rng: RNG): ((Double,Double,Double), RNG) = {
  val (d1, rng1) = double(rng)
  val (d2, rng2) = double(rng1)
  val (d3, rng3) = double(rng2)
  ((d1, d2, d3), rng3)
}
