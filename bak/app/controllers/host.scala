package controllers

import help.Page
import play.api.mvc.{ Action, Controller }
import views.html
import com.kolor.docker.api._
import com.kolor.docker.api.json.Formats._
import scala.concurrent.ExecutionContext.Implicits.global


/**
 * Created by rika on 2015/10/24.
 */
class Host extends Controller{


  def list(page: Int) = Action { implicit request =>
    implicit val docker = Docker("192.168.33.10")
    val maybeContainers = docker.images()
    for {
      containers <- maybeContainers
    } yield {
      containers.map(c => println(s"Container: $c"))
    }
    Ok(html.host.list(Page(0,20,1,List("192.168.137.33"))))
  }
}
