ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "Session4Day2Assignment1"
  )
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test