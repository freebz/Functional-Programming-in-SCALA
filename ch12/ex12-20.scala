def composeM[F[_],G[_]](F: Monad[F], G: Monad[G], T: Traverse[G]):
    Monad[({type f[x] = F[G[x]])}#f] =
  new Monad[({type f[x] = F[G[x]])}#f] {
    def unit[A](a: => A): G[H[A]] = G.unit(H.unit(a))
    override def flatMap[A,B](mna: G[H[A]])(f: A => G[H[B]]): G[H[B]] =
      G.flatMap(mna)(na => G.map(T.traverse(na)(f))(H.join))
  }
