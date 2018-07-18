def map[A,B](a: Parser[A])(f: A => B): Parser[B] =
  flatMap(a)(succeed(f(_)))
