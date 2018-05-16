package ScalaCookBook

/**
 * Hello world!
 *
 */
import WindowFunctionCheck._
object App  {
  println( "Hello World!" )

  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement :String = s.map(c => (c-1).toChar)
    def hideAll: String = s.replaceAll(".", "*")
    def plusOne = s.toInt + 1
    def asBoolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }

  def main(args: Array[String]): Unit = {
    println("Trial Run")
    val num = "44"
//    println("Increment = " + num.increment)
//    println("Decrement = " + num.decrement)
//    println("HideAll = " + num.hideAll)
//    println("PlusOne = " + num.plusOne)
//    println("Bool = " + num.asBoolean)
    runCheck
  }
}


