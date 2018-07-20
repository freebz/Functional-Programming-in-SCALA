// 목록 11.6 Order 클래스의 정의

case class Order(item: Item, quantity: Int)
case class Item(name: String, price: Double)

val genOrder: Gen[Order] = for {
  name <- Gen.stringN(3)
  price <- Gen.unitform.map(_ * 10)
  quantity <- Gen.choose(1, 100)
} yield Order(Item(name, price), quantity)
