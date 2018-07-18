// 목록 9.3 파서를 확정 상태로 만드는 addCommit 메서드를 이용한 구현

def flatMap[A,B](f: Parser[A])(g: A => Parser[B]): Parser[B] =
  s => f(s) match {
    case Success(a,n) => g(a)(s.advanceBy(n))
                         .addCommit(n != 0)
                         .advanceSuccess(n)
    case e@Failure(_,_) => e
  }
