// 목록 12.4 Option 모나드를 이용한 결과 조합

val isdByName: Map[String,Int]
val depts: Map[Int,String] = ...
val salaries: Map[Int,Double] = ...
val o: Option[String] =
  idsByName.get("Bob").flatMap { id =>
    F.map2(depts.get(id), salaries.get(id))(
      (dept, salary) => s"Bob in $dept makes $salary per year"
    )
  }
