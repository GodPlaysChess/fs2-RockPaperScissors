
name := "rps"

version := "1.0"

scalaVersion := "2.12.2"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "org.typelevel" %% "cats" % "0.9.0"

libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.2"

libraryDependencies += "co.fs2" %% "fs2-core" % "0.9.5"

libraryDependencies += "co.fs2" %% "fs2-io" % "0.9.5"

libraryDependencies += "co.fs2" %% "fs2-cats" % "0.3.0"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

