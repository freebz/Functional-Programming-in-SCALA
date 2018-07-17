def sum(ns: List[Int]): Int


val intList = Gen.lisfOf(Gen.choose(0,100))

val prop = forAll(intList)(ns => sum(ns) == sum(ns.reverse) &&
  forAll(intList)(ns => sum(ns) == sum(ns)) &&
  forAll(intList)(ns => sum(List()) == 0)
