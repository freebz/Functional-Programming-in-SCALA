// 목록 4.3 Option의 용례

def parseInsuranceRateQuote(
  age: String,
  numberOfSpeedingTickets: String): Option[Double] = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
  }

def Try[A](a: => A): Option[A] =
  try Some(a)
  catch { case e: Exception => None }
