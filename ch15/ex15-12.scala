def join[F[_],O](p: Process[F, Process[F, O]]): Process[F, O] =
  p.flatMap(pa => pa)
