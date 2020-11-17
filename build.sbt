name := "spark-file-splitter"

version := "0.1"

scalaVersion := "2.12.12"


val sparkVersion = "3.0.1"


resolvers += "Maven Dependencies" at "https://repo1.maven.org/maven2/"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalactic" %% "scalactic" % "3.2.2",
  "org.scalatest" %% "scalatest" % "3.2.2" % "test"
)