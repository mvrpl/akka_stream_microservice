lazy val akkaHttpVersion  = "10.2.3"
lazy val akkaVersion      = "2.6.14"

// Run in a separate JVM, to make sure sbt waits until all threads have
// finished before returning.
// If you want to keep the application running while executing other
// sbt tasks, consider https://github.com/spray/sbt-revolver/
fork := true

lazy val root = (project in file("."))
  .enablePlugins(AkkaGrpcPlugin)
  .settings(
    inThisBuild(List(
      organization    := "mvrpl.dev",
      scalaVersion    := "2.13.4"
    )),
    name := "sapi",
    libraryDependencies ++= Seq(
      "com.typesafe.akka"     %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka"     %% "akka-http2-support"   % akkaHttpVersion,
      "com.typesafe.akka"     %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka"     %% "akka-actor-typed"     % akkaVersion,
      "com.typesafe.akka"     %% "akka-stream"          % akkaVersion,
      "com.typesafe.akka"     %% "akka-discovery"       % akkaVersion,
      "ch.qos.logback"        % "logback-classic"       % "1.2.3",

      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"                % "3.1.4"         % Test
    )
  )
