// 목록 2.4 배열에서 한 요소를 찾는 다형적 함수

def findFirst[A](as: Array[A], p: A => Boolean): Int = {
  @annotation.tailrec
  def loop(n: Int): Int =
    if (n >= as.length) - 1
    else if (p(as(n))) n
    else loop(n + 1)

  loop(0)
}
