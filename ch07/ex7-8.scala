val a = lazyUnit(42 + 1)
val S = Executors.newFixedThreadPool(1)
println(Par.equals(S)(a, fork(a)))


def fork[A](a: => Par[A]): Par[A] =
  es => es.submit(new Callable[A] {
    def call = a(es).get
  })
