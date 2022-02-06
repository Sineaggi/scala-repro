scalacOptions ++= Seq(
  "-target:jvm-1.8"
)

val commonSettings = Seq(
  organization := "com.example",
  version := sys.env.getOrElse("VERSION", "1.0-SNAPSHOT"),
  scalaVersion := "2.11.12",
  dependencyOverrides ++= Set(
  )
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,
    name := "sr",
    libraryDependencies ++= dependencies,
    publishArtifact := false
  )
  .enablePlugins(PlayJava)

lazy val dependencies = Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.12",
  "org.scala-lang" % "scala-library" % "2.11.12",
  "org.scala-lang" % "scala-reflect" % "2.11.12"
)
