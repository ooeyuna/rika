package controllers

import help.Page
import play.api.mvc.{ Action, Controller }
import views.html
import com.kolor.docker.api._
import com.kolor.docker.api.json.Formats._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration


/**
 * Created by rika on 2015/10/24.
 */
class ServerController extends ApplicationController{

  def list(page: Int = 1) = Action { implicit request =>
    implicit val docker = Docker("192.168.33.10",4342)
    val messages = Await.result(docker.containers(), Duration.create(10,"second"))
    Ok(html.host.list(Page(0,20,1,messages.map(c => s"Container: $c"))))
  }
}
