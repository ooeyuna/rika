name := """rika"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-target:jvm-1.8")

libraryDependencies ++= Seq(cache, ws)

resolvers := Seq(
  "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/",
  "Sonatype" at "http://oss.sonatype.org/content/groups/public/",
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.4.2" % "provided" cross CrossVersion.binary,
  "com.typesafe.play" %% "play-test" % "2.4.2" % "test" cross CrossVersion.binary,
  "org.specs2" % "specs2" % "2.3.12" % "test" cross CrossVersion.binary,
  "junit" % "junit" % "4.8" % "test" cross CrossVersion.Disabled,
  "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.0.2",
  "org.webjars" %% "webjars-play" % "2.4.0",
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.webjars" % "bootswatch-united" % "3.3.4+1",
  "org.webjars" % "html5shiv" % "3.7.0",
  "org.webjars" % "respond" % "1.4.2",
  "com.netaporter" %% "scala-uri" % "0.4.2",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.3",
  "org.specs2" %% "specs2" % "2.4.2" % "test",
  "ch.qos.logback" % "logback-core" % "1.1.3",
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "org.apache.commons" % "commons-compress" % "1.8.1"
)

includeFilter in (Assets, LessKeys.less) := """*.less"""

routesGenerator := InjectedRoutesGenerator

pipelineStages := Seq(rjs)
