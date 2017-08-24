name := "rake"

version := "0.1"

scalaVersion := "2.12.3"

val scalaTestVersion = "3.0.1"
val scalatic: ModuleID = "org.scalactic" %% "scalactic" % scalaTestVersion
val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % scalaTestVersion % Test

libraryDependencies ++= Seq(scalatic, scalaTest)
