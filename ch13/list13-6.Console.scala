// 목록 13.6 Console 형식의 정의

sealed trait Console[A] {
  def toPar: Par[A]
  def toThunk: () => A
}
case object ReadLine extends Console[Option[String]] {
  def toPar = Par.lazyUnit(run)
  def toThunk = () => run

  def run: Option[String] =
    try Some(readLine())
    catch { case e: Exception => None }
}
case class PrintLine(line: String) extends Console[Unit] {
  def toPar = Par.lazyUnit(println(line))
  def toThunk = () => println(line)
}
