def string(s: String): Parser[A] =
  (input: String) =>
    if (input.startsWith(s))
      Right(s)
    else
      Left(Location(input).toError("Expected: " + s))


def toError(msg: String): ParseError =
  ParseError(List((this, msg)))
