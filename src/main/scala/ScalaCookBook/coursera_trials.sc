val nums = List[Int](4, 5, 6, 7, 10, 40, 3)

val numDiffs = nums.map { x =>
  val diff = nums.filter(n => n != x).map(j => (x, j, j - x))
  diff
}

numDiffs.flatten.foreach(println)

val keep = numDiffs.flatten

keep.map( x => (x._1,(x._3.toDouble))).reduce((x1,x2) => math.max(x1._2,x2._2))
