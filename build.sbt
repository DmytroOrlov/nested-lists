lazy val `nested-lists` = (project in file("."))
  .settings(
    version := "1.0",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "ch.epfl.lamp" %% "scala-records" % "0.5-SNAPSHOT",
      "com.storm-enroute" %% "scalameter" % "0.8.2",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    )
  )
