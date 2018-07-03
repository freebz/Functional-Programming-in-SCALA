// 목록 1.3 여러 잔의 커피를 구매하는 buyCoffees

class Cafe {

  def buyCoffee(cc: CreditCard): (Coffee, Charge) = ...

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (Coffees, charges.reduce((c1,c2) => c1.combine(c2)))
  }
}
