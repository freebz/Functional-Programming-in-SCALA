def depth[A](t: Tree[A]): Int = t match {
  case Leaf(_) => 0
  case Branch(l, r) => (depth(l) max delth(r)) + 1
}
