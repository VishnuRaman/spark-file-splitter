package spark.file.filter

import java.util.Properties

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.sql.{DataFrame, SparkSession}

class IOServices {

  def getFileSystem(): FileSystem ={
    val conf = new Configuration()
    //conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020")
    val fs= FileSystem.get(conf)
    fs
  }

  def readPropertyFile(path:String)(implicit fileSystem:FileSystem):Properties ={
    val stream = fileSystem.open(new Path(path))
    val prop = new Properties()
    prop.load(stream)
    prop
  }

  def readCSVFile(path:String)(implicit sparkSession: SparkSession): DataFrame ={
    val loadedDf = sparkSession.read.format("csv").load(path)
    loadedDf
  }



}

