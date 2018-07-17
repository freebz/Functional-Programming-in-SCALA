// 목록 8.1 ScalaCheck의 속성

val intList = Gen.listOf(Gen.choose(0,100))

val prop =
  forAll(intList)(ns => ns.reverse.reverse == ns) &&
  forAll(intList)(ns => ns.headOption == ns.reverse.lastOption)

val failingProp = forAll(intList)(ns => ns.reverse == ns)
