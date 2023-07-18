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

  println("----------------------------------------------------------------")
  //Using for-loop, this way we are using for-loop as a statement
  for(i <- 1 to 10 ){
    println(i)
  }

  println("----------------------------------------------------------------")
  //using for-loop with yield, this way we are using for-loop as an expression
  val squareCollect = for(i <- 1 to 100) yield i*i
  println(squareCollect)
  for(i <- squareCollect){
    println(i)
  }

  // using multiple generators
  val sequence = for(i<- 1 to 10; j <- 10 to 100)yield i*j
  //This is basically working like a nested for-loop
  // first 10 to 100 are multiplied by 1, then 2, then 3 and so on.
  print(sequence)
  //thus giving us
  //Vector(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
  // 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
  // 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58,
  // 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75,
  // 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
  // 94, 95, 96, 97, 98, 99, 100,

  // 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54,
  // 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90,
  // 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 118, 120, 122,
  // 124, 126, 128, 130, 132, 134, 136, 138, 140, 142, 144, 146, 148, 150, 152,
  // 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176, 178, 180, 182,
  // 184, 186, 188, 190, 192, 194, 196, 198, 200,

  // 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81,
  // 84, 87, 90, 93, 96, 99, 102, 105, 108, 111, 114, 117, 120, 123, 126, 129,
  // 132, 135, 138, 141, 144, 147, 150, 153, 156, 159, 162, 165, 168, 171, 174,
  // 177, 180, 183, 186, 189, 192, 195, 198, 201, 204, 207, 210, 213, 216, 219,
  // 222, 225, 228, 231, 234, 237, 240, 243, 246, 249, 252, 255, 258, 261, 264,
  // 267, 270, 273, 276, 279, 282, 285, 288, 291, 294, 297, 300,

  // 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96, 100, 104, 108,
  // 112, 116, 120, 124, 128, 132, 136, 140, 144, 148, 152, 156, 160, 164, 168,
  // 172, 176, 180, 184, 188, 192, 196, 200, 204, 208, 212, 216, 220, 224, 228,
  // 232, 236, 240, 244, 248, 252, 256, 260, 264, 268, 272, 276, 280, 284, 288, 292, 296,
  // 300, 304, 308, 312, 316, 320, 324, 328, 332, 336, 340, 344, 348, 352, 356, 360, 364,
  // 368, 372, 376, 380, 384, 388, 392, 396, 400,

  // 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 110, 115, 120, 125, 130, 135, 140,
  // 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215, 220, 225,
  // 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 290, 295, 300, 305, 310,
  // 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365, 370, 375, 380, 385, 390, 395,
  // 400, 405, 410, 415, 420, 425, 430, 435, 440, 445, 450, 455, 460, 465, 470, 475, 480,
  // 485, 490, 495, 500,

  // 60, 66, 72, 78, 84, 90, 96, 102, 108, 114, 120, 126, 132, 138, 144, 150, 156, 162,
  // 168, 174, 180, 186, 192, 198, 204, 210, 216, 222, 228, 234, 240, 246, 252, 258, 264,
  // 270, 276, 282, 288, 294, 300, 306, 312, 318, 324, 330, 336, 342, 348, 354, 360, 366,
  // 372, 378, 384, 390, 396, 402, 408, 414, 420, 426, 432, 438, 444, 450, 456, 462, 468,
  // 474, 480, 486, 492, 498, 504, 510, 516, 522, 528, 534, 540, 546, 552, 558, 564, 570, 576,
  // 582, 588, 594, 600,

  // 70, 77, 84, 91, 98, 105, 112, 119, 126, 133, 140, 147, 154, 161, 168, 175, 182, 189, 196,
  // 203, 210, 217, 224, 231, 238, 245, 252, 259, 266, 273, 280, 287, 294, 301, 308, 315, 322,
  // 329, 336, 343, 350, 357, 364, 371, 378, 385, 392, 399, 406, 413, 420, 427, 434, 441, 448,
  // 455, 462, 469, 476, 483, 490, 497, 504, 511, 518, 525, 532, 539, 546, 553, 560, 567, 574,
  // 581, 588, 595, 602, 609, 616, 623, 630, 637, 644, 651, 658, 665, 672, 679, 686, 693, 700,

  // 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224,
  // 232, 240, 248, 256, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 352, 360, 368, 376,
  // 384, 392, 400, 408, 416, 424, 432, 440, 448, 456, 464, 472, 480, 488, 496, 504, 512, 520, 528,
  // 536, 544, 552, 560, 568, 576, 584, 592, 600, 608, 616, 624, 632, 640, 648, 656, 664, 672, 680,
  // 688, 696, 704, 712, 720, 728, 736, 744, 752, 760, 768, 776, 784, 792, 800,

  // 90, 99, 108, 117, 126, 135, 144, 153, 162, 171, 180, 189, 198, 207, 216, 225, 234, 243, 252, 261,
  // 270, 279, 288, 297, 306, 315, 324, 333, 342, 351, 360, 369, 378, 387, 396, 405, 414, 423, 432, 441,
  // 450, 459, 468, 477, 486, 495, 504, 513, 522, 531, 540, 549, 558, 567, 576, 585, 594, 603, 612
  // , 621, 630, 639, 648, 657, 666, 675, 684, 693, 702, 711, 720, 729, 738, 747, 756, 765, 774, 783,
  // 792, 801, 810, 819, 828, 837, 846, 855, 864, 873, 882, 891, 900,

  // 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280,
  // 290, 300, 310, 320, 330, 340, 350, 360, 370, 380, 390, 400, 410, 420, 430, 440, 450, 460, 470,
  // 480, 490, 500, 510, 520, 530, 540, 550, 560, 570, 580, 590, 600, 610, 620, 630, 640, 650, 660,
  // 670, 680, 690, 700, 710, 720, 730, 740, 750, 760, 770, 780, 790, 800, 810, 820, 830, 840, 850,
  // 860, 870, 880, 890, 900, 910, 920, 930, 940, 950, 960, 970, 980, 990, 1000)

  val collectionOfValues_1=for(i<-1 to 10; j<-1 to 10;product=i*j;if product%2 == 0 && product %3 == 0)yield product
  for(i <- collectionOfValues_1){
    println(i)
  }
  //kadane's algorithm using for-loop with generator and guards
  def kadaen_Algo(array:Array[Int]):Int={
    var subSeqSum = 0
    var maxSum = 0
    for(i<-array;if subSeqSum+i > 0){
      subSeqSum += i
      maxSum = math.max(subSeqSum,maxSum)
    }
     maxSum
  }

  //using curly-braces instead of parentheses in for-expression
  val collectValues = for{
    i<- 1 to 5
    j<- 1 to 5
    product = (i*j)
    if product % 2 == 0
  }yield product
  println(collectValues)

  val eightAsString = "8"
  val num = try{
    eightAsString.toInt
  }catch{
    case e:NumberFormatException => 0
    case e:ArithmeticException => 0
  }finally{
    println("Cleaning things up!!")
  }
  println(s"value of num is $num")
  //if we change eightAsString's value from 8 to A, num becomes 0

  //Implementing Linear recursion to calculate Fibonacci values
  println(s"the 40th fibonacci value is ${fibonacciNumber(40)._1}") //102334155
  println(s"the 40th fibonacci value is ${BinetFormula_ForFibonacci(40)}") //102334155
  println(s"the 0th fibonacci value is ${BinetFormula_ForFibonacci(0)}") //0
  println(s"the 1st fibonacci value is ${BinetFormula_ForFibonacci(1)}") //1
  println(s"the 2nd fibonacci value is ${BinetFormula_ForFibonacci(2)}") //1
  println(s"the 5th fibonacci value is ${BinetFormula_ForFibonacci(5)}") //5
  println(s"the 10th fibonacci value is ${BinetFormula_ForFibonacci(10)}") //55
  println(s"the 20th fibonacci value is ${BinetFormula_ForFibonacci(15)}") //610

  square_Error(9)

}
// Linear Recursion applied to calculate Fibonacci numbers
def fibonacciNumber(value:Int):(Int,Int)={
  if(value<2){
    (1,0)
  }else{
    val tup = fibonacciNumber(value-1)
    (tup._1+tup._2,tup._1)
  }
}

//Fibonacci numbers using Binet's formula
def BinetFormula_ForFibonacci(value:Int):Int={
  val sqrtFive = math.sqrt(5)
  val numerator = math.pow(1+sqrtFive,value) - math.pow(1-sqrtFive,value)
  val denominator = math.pow(2,value)*sqrtFive
  (numerator/denominator).toInt
}

//Experimental Code, to demonstrate the need for specifying return type
def square_Error(x:Double)={
  x*x //this statement is simply ignored
  println(s"Squaring $x")
}

def square_Fixed(x:Double):Double={
  x*x
  println(s"Squaring $x")
}
/*
* Above code gives us a compilation error
  Found:    Unit
  Required: Double
    println(s"Squaring $x")
* */