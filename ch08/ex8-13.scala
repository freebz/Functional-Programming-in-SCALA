def listOf1[A](a: Gen[A]): Gen[List[A]] =
  SGen(n => a.listOfN(n max 1))

val maxProp = forAll(listOf1(smallInt)) { ns =>
  val max = ns.max
  !ns.exists(_ > max) // No value greater than `max` should exists in `ns`
}
