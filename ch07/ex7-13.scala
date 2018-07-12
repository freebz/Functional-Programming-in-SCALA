def chooser[A,B](pa: Par[A])(choices: A => Par[B]): Par[B] =
  es => {
    val a = run(es)(pa).get
    run(es)(choices(a))
  }

/* `chooser` is usually called `flatMap` or `bind`. */
def flatMap[A,B](p: Par[A])(f: A => Par[B]): Par[B] =
  es => {
    val a = run(es)(p).get
    run(es)(f(a))
  }

def choice[A](cond: Par[Boolean])(t: Par[A], f: Par[A]): Par[A] =
  flatMap(cond)(b => if (b) t else f)

def choiceN[A](n: Par[Int])(choices: List[Par[A]]): Par[A] =
  flatMap(n)(i => choices(i))
