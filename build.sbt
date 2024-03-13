lazy val `magnolia-test` = project.in(file(".")).settings(
  libraryDependencies += "com.softwaremill.magnolia1_3" %% "magnolia" % "1.3.4",
  crossScalaVersions := List("3.4.0", "3.3.3"),
  scalaVersion := crossScalaVersions.value.head,
)

