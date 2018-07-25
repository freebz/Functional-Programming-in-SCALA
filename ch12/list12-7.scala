// 목록 12.7 format의 리팩토링

val F: Applicative[Option] = ...

def format(name: Option[String], pay: Option[Double]): Option[String] =
  F.map(e, pay) { (e, pay) => s"$e makes $pay" }

def format(e: Option[Employee], pay: Option[Pay]): Option[String] =
  F.map2(e, py) { (e, pay) =>
    s"${e.name} makes ${pay.rate * pay.hoursPerYear}"
  }

val e: Option[Employee] = ...
val pay: Option[Pay] = ...

format(
  F.map(e)(_.name),
  F.map(pay)(pay => pay.rate * pay.hoursPerYear))
