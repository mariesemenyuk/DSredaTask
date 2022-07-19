ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(
    name := """DSredaTask""",
    libraryDependencies ++= Seq(
      guice,
      javaCore, javaJdbc,
      evolutions,
      "com.h2database" % "h2" % "2.1.212",
      "org.mybatis" % "mybatis" % "3.5.10",
      "org.mybatis" % "mybatis-guice" % "3.17",
      "com.google.inject.extensions" % "guice-multibindings" % "4.2.3"
    )
  )