package spark.file.filter
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SparkTest extends AnyFunSuite with BeforeAndAfterAll with Matchers {
  var ss: SparkSession = _
  var sc: SparkContext = _
  var sqlContext: SQLContext = _

  override def beforeAll(): Unit = {
    val master = "local[*]"
    val appName = "SparkFileSplitterTest"
    val conf: SparkConf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)
      .set("spark.driver.allowMultipleContexts", "false")
      .set("spark.ui.enabled", "false")

    ss = SparkSession.builder().config(conf).getOrCreate()

    sc = ss.sparkContext
    sqlContext = ss.sqlContext
    super.beforeAll()
  }

  override def afterAll(): Unit = {
    sc.stop()
    super.afterAll()
  }

  test("reading simple file"){
    val IO = new IOServices()
    implicit val fs = IO.getFileSystem()
    val prop = IO.readPropertyFile("src/test/resources/test_config.properties")
    prop.size() shouldBe 2

  }
}
