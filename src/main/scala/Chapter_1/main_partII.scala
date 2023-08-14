package Chapter_1
//import statement renaming and hiding
//the following statement imports java.util.List as JavalList, hides java.util.Map, java.util.Set
import java.util.{List=>JavaList, Map=>_, Set=>_}

//The following statement imports certain method of StdIn object
import io.StdIn.{readInt,readDouble}

//importing module required for reading user-input
import io.StdIn._

// Scope App (Listing 1.1)
/**
 * This application demonstrates scope in Scala programs.
 */
object ScopeApp{
  def main(args:Array[String]):Unit = {
    println("Printing some factorials.")
    val factValue = 5
    println(imperativeFactorial(factValue))
    println(recursiveFactorial_2(factValue))
    print(recursiveFactorial_1(factValue))
  }
  //Can't use factValue here because the scope has closed!!
  def imperativeFactorial(num:Int):Int={
    var prod = 1
    for(i <- 2 to num){
      prod *= i
    }
    prod
  }
  def recursiveFactorial_1(num:Int):Int={
    if(num==1){
      1
    }
    else{
      num*recursiveFactorial_1(num-1)
    }
  }
  def recursiveFactorial_2(num:Int):Int = if(num<2) num else num*recursiveFactorial_2(num-1)
}
object ReadingUserInput{
    def main(args:Array[String]):Unit={
      println(s"What is your name ?")
      val name = readLine()
      println("and what might your age be?")
      val age = readInt()
      println(s"So you are ${name}, ${age} years old!!")
      print("Enter a number: ")
      val num = readInt() //entering 25g gives NumberFormat Exception
      print("Enter another number: ")
      val num2 = readInt()
      print("Enter any name: ");
      val name2 = readLine() //this will not fall to Java error, so you can successfully enter a string when prompted.
      println(s"num1: ${num}, num2: ${num2}, gotcha!! ")


      //Basic Collections in Scala
      //To create an Array (mutable, fixed-length):
      val nums:Array[Int] = Array(1,2,3,4,5,6)

      //To create a List (immutable sequence)
      val nums_2:List[String] = List("Scala", "is", "quite", "awesome", "!")
      println(nums) //this prints [I@43a25848, {probably because nums doesn't have a .toString() method}
      println(nums.mkString("Array(", ", ", ")")) //Array(1, 2, 3, 4, 5, 6)
      println(nums_2) // List(Scala, is, quite, awesome, !)

      //Unlike Java, elements of List, Array are accessed usign parentheses
      println(nums(0))
      println(nums(1))

      println(nums_2(3))

      // println(nums_2(5))
      /*
      * Exception in thread "main" java.lang.IndexOutOfBoundsException: 5
        at scala.collection.LinearSeqOps.apply(LinearSeq.scala:117)
        at scala.collection.LinearSeqOps.apply$(LinearSeq.scala:114)
        at scala.collection.immutable.List.apply(List.scala:79)
        at Chapter_1.ReadingUserInput$.main(main_partII.scala:73)
        at Chapter_1.ReadingUserInput.main(main_partII.scala)
      * */

      //Making changes to mutable arrays
      nums(0) = 1_000_000_000;

      //nums_2(1) = "Phoenix" //this gives an error saying, "value update is not a member of List[String] - did you mean nums_2.updated? "

      //nums_2.updated(5,"Hello!!")
      /*
      * Above statement gives the following error:
      Exception in thread "main" java.lang.IndexOutOfBoundsException: 5 is out of bounds (min 0, max 4)
        at scala.collection.immutable.List.updated(List.scala:240)
        at Chapter_1.ReadingUserInput$.main(main_partII.scala:87)
        at Chapter_1.ReadingUserInput.main(main_partII.scala)
      * */
      //println(nums_2)

      val newOne = nums_2.updated(4, "GREAT!") //This method returns a new updated collection
      println(nums_2)//List(Scala, is, quite, awesome, !)
      println(newOne)//List(Scala, is, quite, awesome, GREAT !)

      //Creating List/Arrays using .fill method
      val array_1 = Array.fill(20)(417)
      val array_2 = Array.fill(10)("")
      val List_1 = List.fill(10)(math.random*10)
      //List(1.021035474832922, 6.007151613281586, 9.34129527287649,
      // 6.5938145524024385, 0.6875438766521313, 5.248869631440806, 2.307378599261951,
      // 6.715942015822046, 1.6793405232797332, 6.529758725738402)
      println(List_1)

      val countess = Array.tabulate(100)(i=>i+2) //for each index i, store i+2 value
      print(countess.mkString("[",",","]"));
      //[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
      // 27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,
      // 49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,
      // 71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,
      // 93,94,95,96,97,98,99,100,101]




    }
}