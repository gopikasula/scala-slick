import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "slick",
    libraryDependencies += scalaTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.36",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3",
  "com.typesafe.slick" %% "slick" % "3.2.3",
  "com.google.inject" % "guice" % "4.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "com.h2database" % "h2" % "1.4.187" % "test"
)
