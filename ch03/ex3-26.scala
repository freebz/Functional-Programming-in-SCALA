def maximum(t: Tree[Int]): Int = t match {
  case Leaf(n) => n
  case Branch(l, r) => maximum(l) max maximum(r)
}
