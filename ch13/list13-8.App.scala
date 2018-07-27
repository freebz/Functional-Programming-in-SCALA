// 목록 13.8 부수 효과를 '그냥' 효과로 바꾸기

abstract class App {
  import java.util.concurrent._

  def unsafePerformIO[A](a: IO[A])(pool: ExecutorService): A =
    Par.run(pool)(run(a)(parMonad))

  def main(args: Array[String]): Unit = {
    val pool = Executors.fixedThreadPool(8)
    unsafePerformIO(pureMain(args))(pool)
  }

  def pureMain(args: IndexedSeq[String]): IO[Unit]
}
