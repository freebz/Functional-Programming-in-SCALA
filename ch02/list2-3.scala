// 목록 2.3 배열에서 문자열을 찾는 단형적 함수

def findFirst(ss: Array[String], key: String): Int = {
  @annotation.tailrec
  def loop(n: Int): Int =
    if (n >= ss.length) - 1
    else if (ss(n) == key) n
    else loop(n + 1)

  loop(0)
}
