// 목록 6.1 scala.util.Random으로 난수 발생

val rng = new scala.util.Random

rng.nextDouble
// res1: Double = 0.9867076608154569

rng.nextDouble
// res2: Double = 0.8455696498024141

rng.nextInt
// res3: Int = -623297295

rng.nextInt(10)
// res4: Int = 4
