val parMonad = new Monad[Par] {
  def unit[A](a: => A): Par[A] = Par.unit(a)
  def flatMap[A, B](ma: Par[A])(f: A => Par[B]): Par[B] = Par.flatMap(ma)(f)
}

val parserMonad = new Monad[Parser] {
  def unit[A](a: => A): Parser[A] = p.succeed(a)
  def flatMap[A, B](ma: Parser[A])(f: A => Parser[B]): Parser[B] = p.flatMap(ma)(f)
}

val optionMonad = new Monad[Option] {
  def unit[A](a: => A): Option[A] = Some(a)
  def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Parser[B] = ma flatMap f
}

val streamMonad = new Monad[Stream] {
  def unit[A](a: => A) = Stream(a)
  def flatMap[A, B](ma: Stream[A])(f: A => Stream[B]) = ma flatMap f
}

val listMonad = new Monad[List] {
  def unit[A](a: => A) = List(a)
  def flatMap[A, B](ma: List[A])(f: A => List[B]) = ma flatMap f
}
