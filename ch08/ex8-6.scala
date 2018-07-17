def flatMap[B](f: A => Gen[B]): Gen[B] =
  Gen(sample.flatMap(a => f(a).sample))

def listOfN(size: Gen[Int]): Gen[List[A]] =
  Gen.listOfN(size, this)

def listOfN(size: Gen[Int]): Gen[List[A]] =
  size flatMap (n => this.listOfN(n))
