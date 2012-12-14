import sbt._
import Keys._
import PlayProject._

// War Support
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

    val appName         = "postal"
    val appVersion      = "0.3b"

    val appDependencies = Seq(
      "mysql" % "mysql-connector-java" % "5.1.21"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
        // Add your own project settings here
        Play2WarKeys.servletVersion := "3.0"
    ).settings(Play2WarPlugin.play2WarSettings: _*)

}
