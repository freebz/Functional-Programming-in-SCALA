// 목록 1.1 부소 효과가 있는 프로그램

class Cafe {

  def buyCoffee(cc: CreditCard): Coffee = {

    val cup = new Coffee()

    cc.charge(cup.price)

    cup

  }
}
