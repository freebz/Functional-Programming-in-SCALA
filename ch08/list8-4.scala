// 목록 8.4 주어진 최대 크기까지 검례들을 생성

type MaxSize = Int
case class Porp(run: (MaxSize,TestCases,RNG) => Result)

def forAll[A](g: SGen[A])(f: A => Boolean): Prop =
  forAll(g(_))(f)

def forAll[A](g: Int => Gen[A])(f: A => Boolean): Prop = Prop {
  (max,n.rng) =>
  val casesPerSize = (n + (max - 1)) / max
  val props: Stream[Prop] =
    Stream.from(0).take((n min max) + 1).map(i => forAll(g(i))(f))
  val prop: Prop =
    props.map(p => Prop { (max, _, rng) =>
      p.run(max, casesPerSize, rng)
    }).toList.reduce(_ && _)
  prop.run(max,n,rng)
}
