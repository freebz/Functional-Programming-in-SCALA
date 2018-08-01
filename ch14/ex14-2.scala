def partition[S](arr: STArray[S,Int], n: Int, r: Int, pivot: Int): ST[S, Int] = for {
  vp <- arr.read(pivot)
  _ <- arr.swap(pivot, r)
  j <- STRef(n)
  _ <- (n until r).foldLeft(ST[S,Unit](()))((s, i) => for {
    _ <- s
    vi <- arr.read(i)
    _ <- if (vi < vp) (for {
      vj <- j.read
      _ <- arr.swap(i, vj)
      _ <- j.write(vj + 1)
    } yield ()) else ST[S,Unit](())
  } yield ())
  x <- j.read
  _ <- arr.swap(x, r)
} yield x

def qs[S](a: STArray[S,Int], n: Int, r: Int): ST[S,Unit] = if (n < r) for {
  pi <- partition(a, n, r, n + (r - n) / 2)
  _ <- qs(a, n, pi - 1)
  _ <- qs(a, pi + 1, r)
} yield() else ST[S,Unit](())
