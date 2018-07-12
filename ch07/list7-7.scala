// 목록 7.7 Actor를 이용한 map2 구현

def map2[A,B,C](p: Par[A], p2: Par[B])(f: (A,B) => C): Par[C] =
  es = new Future[C] {
    def apply(cb: C => Unit): Unit = {
      var ar: Option[A] = None
      var br: Option[B] = None

      val combiner = Actor[Either[A,B]](es) {
        case Left(a) => br match {
          case None => ar = Some(a)
          case Some(b) => eval(es)(cb(f(a, b)))
        }

        case Right(b) => ar match {
          case None => Some(b)
          case Some(a) => eval(es)(cb(f(a, b)))
        }
      }

      p(es)(a => combiner ! Left(a))
      p2(es)(b => combiner ! Right(b))
    }
  }
