package ScalaCookBook

import org.apache.spark.sql.{Row, SparkSession}

object WindowFunctionCheck {

  case class partn_cs(id: Int,name: String, check1: String, check2: String)
  def runCheck {
    val spark = SparkSession.builder.master("local[4]").getOrCreate()

    import spark.implicits._
    val partn = spark.createDataFrame(Seq((1, "Rijo", "Addr1", "Access1"), (1, "Rijo", "Addr2", "Access2"), (2, "Vijo", "Addr1", "Access1"),
      (2, "Vijo", "Addr3", "Access2"), (3, "Vijo", "Addr4", "Access0")
    )).toDF("id","name","check1","check2").as[partn_cs]

    println(partn.describe())
    partn.rdd.foreach(println)

    val windowed = partn.rdd
//      .map( x => (x.id,x.name,(x.check1,x.check2)))
      .keyBy( k => (k.id,k.name))
      .sortBy( s => s._2.check1,false)
//        .aggregate(Map.empty[((String,String),Row)]((x,y) => x + y,(x1,x2) => (x1 ++ x2))

    println("Windowed debug=> " + windowed.toDebugString)

    windowed.foreach(println)
  }

}


