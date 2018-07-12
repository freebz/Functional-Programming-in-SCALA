def join[A](a: Par[Par[A]]): Par[A] =
  es => run(es)(run(es)(a).get())

def join[A](a: Par[Par[A]]): Par[A] =
  flatMap(a)(x => x)

def flatMap[A,B](p: Par[A])(f: A => Par[B]): Par[B] =
  join(map(p)(f))
