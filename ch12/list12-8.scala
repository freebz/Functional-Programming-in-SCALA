// 목록 12.8 Monoid를 Applicative로 변환

type Const[M, B] = M

implicit def monoidApplicative[M](M: Monid[M]) =
  new Applicative[({ type f[x] = Const[M, x] })#f] {
    def unit[A](a: => A): M = M.zero
    def map2[A,B,C](m1: M, m2: M)(f: (A,B) => C): M = M.op(m1,m2)
  }
