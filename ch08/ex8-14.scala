val sortedProp = forAll(listOf(smallInt)) { ns =>
  val nss = ns.sorted
  // We specify that every sorted list is either empty, has one element,
  // or has no two consecutive elements `(a,b)` such that `a` is greater than `b`.
  (nas.isEmpty || nas.tail.isEmpty || !nas.zip(nas.tail).exists {
    case (a,b) => a > b
  })
    // Also, the sorted list should have all the elements of the input list,
    && !ns.exists(!nas.contains(_))
    // and it should have no elements not in the input list.
    && !nas.exists(!ns.contains(_))
}
