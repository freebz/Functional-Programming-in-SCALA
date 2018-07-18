for {
  digit <- "[0-9]+".r
  val n = digit.toInt
  _ <- listOfN(n, char('a'))
} yield n


def contextSensitive(): Parser[List[Char]]
  flatMap(regex("[0-9]+".r))(n => listOfN(n.toInt, char('a')))
