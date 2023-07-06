package Chapter_1
@main
def main():Unit={
  //Section 1.4.1 Lambda Expressions/Closures
  //Lambda expression is a functional programming construct that allows us write functions as expressions
  //for example, function to calculate square of argument-
  val square = (x:Double)=>math.pow(x,2)
  println(square(26))
  //GCD lambda
  val gcd:(Double,Double)=>Double = (numA,numB) =>{
    var num1 = numA
    var num2 = numB
    while(num2!=0){
      val remainder = num1 % num2
      num1 = num2
      num2 = remainder
    }
    num1
  }
  println(gcd(6,12))
  println(gcd(10,5))
  println(gcd(14,28));
  println(gcd(21,6))
  println(gcd(0,1))
  println(gcd(0,0))

  //Other formats of writing lambdas
  val square_2:Double=>Double=x=>x*x
  println(square_2(23))

  //Even shorter, here the underscore is a placeholder for the parameter
  val square_3:Double=>Double=math.pow(_,2)
  println(square_3(23))

  val twice_1:Double=>Double= x=>x*2
  val twice:Double=>Double = _*2

  println(twice_1(84))
  println(twice(42))

  println("----------------------------------------------------------------")
  //Conditionals in scala
  var age:Int = 5

  //Imperative
  var price:Int = 0
  if(age<10 || age>64){
    price = 8
  }else{
    price = 12
  }
  println(price)

  //If as an expression
  price = if(age<10 || age>60)8 else 12
  println(price)

  //You can also include `else if` in an if-expression
  price = if(age<10 || age>60)8 else if(age>20 && age<30)23 else 500
  println(price)

  // price = 12?(age>9):34 // Scala doesn't support ternary operator





}