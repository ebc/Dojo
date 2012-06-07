organization := "com.github.ebc"

name := "quarto"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.2"

libraryDependencies += "org.specs2" %% "specs2" % "1.12-SNAPSHOT"

resolvers ++= Seq("snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
                  "releases"  at "http://oss.sonatype.org/content/repositories/releases")
