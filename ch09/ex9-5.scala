// We could introduce a combinator, `wrap`

def wrap[A](p: => Parser[A]): Parser[A]

// Then define `many` as:

def many[A](p: Parser[A]): Parser[List[A]] =
  map2(p, wrap(many(p)))(_ :: _) or succeed(List())
