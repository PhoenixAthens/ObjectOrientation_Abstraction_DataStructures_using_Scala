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

  println("----------------------------------------------------------------")
  //Using pattern-matching for FIZZBUZZ
  for( i <- 1 until 100){ //until is non-inclusive
    (i%3, i%5) match{
      case (0, 0)=>println("fizzbuzz")
      case (0, _)=>println("fizz")
      case (_, 0)=>println("buzz")
      case _ => println(i.toString)
    }
  }
  val zero = 0
  val anythingElse = 100 // this variable is NOT related to the one inside match
  for (i <- 1 to 100) { //to is inclusive
    (i % 3, i % 5) match { // so underscore - wildcard - can be replaced by a variable
      case (0, 0) => println("fizzbuzz") // but the other values in tuple cannot be
      case (0, anythingElse) => println("fizz")
      case (anythingElse, 0) => println("buzz")
      case anythingElse => println(i.toString)
    }
  }

  println("----------------------------------------------------------------")
  // You could also do the following:
  for (i <- 1 to 50) { //to is inclusive
    (i % 3, i % 5) match { // so underscore - wildcard - can be replaced by a variable
      case (0, 0) => println("fizzbuzz") // but the other values in tuple cannot be
      case (0, anythingElse) => println(s"fizz, with i%5: $anythingElse")
      case (anythingElse, 0) => println(s"buzz, with i%3: $anythingElse")
      case anythingElse => println(s"${i.toString} with i%3: ${anythingElse._1}, i%5: ${anythingElse._2}")
    }
  }

  println("----------------------------------------------------------------")
  //Modifying old code
  for (i <- 1 until 100) { //until is non-inclusive
    (i % 3, i % 5) match {
      case (0, 0) => println("fizzbuzz")
      case (0, other) => println(s"fizz, _:${other}")//this works However case (0,_) => println(s"fizz, _:${_}") DOESN'T
      case (_, 0) => println("buzz")
      case _ => println(i.toString)
    }
  }


}