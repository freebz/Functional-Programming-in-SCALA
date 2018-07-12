def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = fork {
  val fas: List[Par[List[A]]] = ps map (asyncF((a: A) => if (f(a)) List(a) else List()))
  map(sequence(fas))(_.flatten)
}
