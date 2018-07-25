// 목록 12.3 적용성 Option을 이용한 결과 조합

val F: Applicative[Option] = ...

val depts: Map[String,String] = ...
val salaries: Map[String,Double] = ...
val o: Option[String] =
  F.map2(depts.get("Alice"), salaries.get("Alice"))(
    (dept, salary) => s"Alice in $dept makes $salary per year"
  )
