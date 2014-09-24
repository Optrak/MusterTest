organization := "com.optrak"

name := "muster-test"

version := "0.1.0-SNAPSHOT"

resolvers ++= {
  Seq(
    "sonatype.releases" at "https://oss.sonatype.org/content/repositories/releases/",
    "Typesafe releases Repository" at "http://repo.typesafe.com/typesafe/releases/"
  )
}


scalaVersion := "2.11.1"

libraryDependencies ++= {
    Seq(
      "org.slf4j" % "slf4j-api" % "1.7.7",
      "ch.qos.logback" % "logback-classic" % "1.1.2",
      "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
      "joda-time" % "joda-time" % "2.4",
      "org.joda" % "joda-convert" % "1.7",
      "org.json4s" %% "json4s-native" % "3.2.10",
      "org.json4s" %% "muster-core" % "latest.release",
      "org.json4s" %% "muster-codec-json4s" % "0.3.0",
      "org.specs2" %% "specs2" % "2.3.12" % "test"
    )
}

parallelExecution in Test := true

fork := true
