def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
  def loop(n: Int, list: List[Int], rng: RNG) =
    if (n > 0) {
      val (i, r) = rng.nextInt
      loop(n - 1, i :: list, r)
    }
    else (list, rng)

  loop(count, List(), rng)
}
