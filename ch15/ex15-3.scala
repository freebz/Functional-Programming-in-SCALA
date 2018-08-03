def mean: Process[Double,Double] = {
  def go(sum: Double, count: Double): Process[Double,Double] =
    await((d: Double) => emit((sum+d) / (count+1), go(sum+d,count+1)))
  go(0,0, 0.0)
}
