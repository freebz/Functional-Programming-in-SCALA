def &&(p: Prop) = Prop {
  (max,n,rng) => run(max,n,rng) match {
    case Passed => p.run(max, n, rng)
    case x => x
  }
}

def ||(p: Prop) = Prop {
  (max,n,rng) => run(max,n,rng) match {
    case Falsified(msg, _) => p.tag(msg).run(max,n,rng)
    case x => x
  }
}

def tag(msg: String) = Prop {
  (max,n,rng) => run(max,n,rng) match {
    case Falsified(e, c) => Falsified(msg + "\n" + e, c)
    case x => x
  }
}
