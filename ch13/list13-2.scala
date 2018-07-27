// 목록 13.2 화씨를 섭씨로 변환하는 명령식 프로그램

def fahrenheitToCelsius(f: Double): Double =
  (f -32) * 5.0/9.0

def converter: Unit = {
  println("Enter a temperature in degrees Fahrenheit: ")
  val d = readLine.toDouble
  println(fahrenheitToCelsius(d))
}
