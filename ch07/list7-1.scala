// 목록 7.1 분할정복 알고리즘을 이용한 목록 합산

def sum(ints: IndexedSeq[Int]): Int =
  if (ints.size <= 1)
    this.headOption getOrElse 0
  else {
    val (l, r) = ints.splitAt(ints.length/2)
    sum(l) + sum(r)
  }
