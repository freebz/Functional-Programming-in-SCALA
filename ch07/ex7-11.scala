def choiceN[A](n: Par[Int])(choices: List[Par[A]]): Par[A] =
  es => {
    val idx = run(es)(n).get
    run(es)(choices(idx))
  }


def choice(cond: Par[Boolean])(t: Par[A], f: Par[A]): Par[A] =
  choiceN(map(cond)(if (_) 0 else 1))(List(t, f))
