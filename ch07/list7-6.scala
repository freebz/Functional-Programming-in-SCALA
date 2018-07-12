// 목록 7.6 Par를 위한 run의 구현

def run[A](es: ExecutorService)(p: Par[A]): A = {
  val ref = new AtomicReference[A]
  val latch = new CountDownLatch(l)
  p(es) { a => ref.set(a); latch.countDown }
  latch.awiat
  ref.get
}
