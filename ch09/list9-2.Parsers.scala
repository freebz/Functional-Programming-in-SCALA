// 목록 9.2 Parser와 map의 조합

import fpinscala.testing._

trait Parsers[ParseError, Parser[+_]] { self =>

  object Laws {
    def equal[A](p1: Parser[A], p2: Parser[A])(in: Gen[String]): Porp =
      forAll(in)(s => run(p1)(s) == run(p2)(s))

    def mapLaw[A](p: Parser[A])(in: Gen[String]): Prop =
      equal(p, p.map(a => a))(in)
  }
}
