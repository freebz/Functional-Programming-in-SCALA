def sequence[A](fs: List[Rand[A]]): Rand[List[A]] =
  fs.foldright(unit(List[A]()))((f, acc) => map2(f, acc)(_ :: _))


def ints(count: Int)(rng: RNG): (List[Int], RNG) =
  sequence(List.fill(count)(int))
