//val upper = "Hello, This is Rijo".filter(_ != "l").toSeq.map(_.toUpper)
//val dummy = "Hi :: this :: is :: RIJO ^^ working at ^^ home ".split("::")
//def countWords(inputStr: String): Int = {
//  inputStr.trim.split(" ").toList.size
//}
//
//def sum4(a: Int, b: Int)(f: Int => Int): Int = f(a) + f(b)
//
//val d = sum4(2, 2) { x =>
//  x * x
//}
//val d1 = sum4(2, 4){ x=> x*x}

val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
fibs take 10 toList

val strval = "Hi Hi rumor is that how how how did that happen huh hu hu hu hu ?"

case class CountCheck ( word:String , occur: Int)
strval.split("\\s+").toList.groupBy( x => x).map( x=> (x._1,x._2.size)).toList.sorted.foreach(println)
val getCount = strval.split("\\s+") //.map(x => Map(x->1))
  .foldLeft(Map.empty[String, Int]){
    (count, word) => count + (word -> (count.getOrElse(word, 0) + 1))
  }
  getCount.foreach(println)


val wordCount = strval.split( "\\W+").foldLeft(Map.empty[String,Int]){
  (count,word) => count + (word -> (count.getOrElse(word,0) + 1))
}

val x = true
val y = true

def or(x: Boolean, y: => Boolean) = if ( x == y) x else false

val TorF = or(true,false)

