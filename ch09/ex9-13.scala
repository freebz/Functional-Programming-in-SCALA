def string(s: String): Parser[A] =
  (input: String) =>
    if (input.startsWith(s))
      Success(s, s.length)
    else
      Failure(Location(input).toError("Expected: " + s))


def regex(r: Regex): Parser[String] =
  (input: String) => r.findPrefixOf(input) match {
    case None => Failure(Location(input).toError("Expected: " + r))
    case Some(m) => Success(m, m.length)
  }


def succeed[A](a: A): Parser[A] =
  _ => Success(a, 0)


def slice[A](p: Parser[A]): Parser[String] =
  (input: String) => p(s) match {
    case Success(_,n) => Success(s.slice(n),n)
    case f@Failure(_,_) => f
  }
