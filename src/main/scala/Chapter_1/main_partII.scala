package Chapter_1
//import statement renaming and hiding
//the following statement imports java.util.List as JavalList, hides java.util.Map, java.util.Set
import java.util.{List=>JavaList, Map=>_, Set=>_}

//The following statement imports certain method of StdIn object
import io.StdIn.{readInt,readDouble}

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