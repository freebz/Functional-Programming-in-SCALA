def zipWithIndex: Process[I,(O,Int)] =
  this zip (count map(_ - 1))
