// 목록 11.1 Gen과 Parser, Option에 대한 map2의 구현

def map2[A, B, C](
      fa: Gen[A], fb: Gen[B])(f: (A, B) => C): Gen[C] =
  fa flatMap (a => fb map (b => f(a, b)))

def map2[A, B, C](
      fa: Parser[A], fb: Parser[B])(f: (A, B) => C): Parser[C] =
  fa flatMap (a => fb map (b => f(a, b)))

def map2[A, B, C](
      fa: Option[A], fb: Option[B])(f: (A, B) => C): Option[C] =
  fa flatMap (a => fb map (b => f(a, b)))
