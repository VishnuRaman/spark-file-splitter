package spark.file.filter
import org.apache.spark.sql.SparkSession
import org.slf4j.Logger
import org.slf4j.LoggerFactory



object ApplicationMain {
  val LOG = LoggerFactory.getLogger(this.getClass.getName)

  def main(args:Array[String]) :Unit ={

    val jobName = "spark-file-splitter"
    val propertyFile = {
      if(args.length>0) {
        val file = args(0)
        file
      } else{
        val file = ""
      }
    }

    val sparkSession = SparkSession
      .builder()
      .appName(jobName)
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

  }

}
