package controllers

import com.kolor.docker.api._
import com.kolor.docker.api.json.Formats._
import scala.concurrent.ExecutionContext.Implicits.global
import help.Page
import models.Server
import play.api.mvc._
import views.html

import scala.concurrent.{Future, Await}
import scala.concurrent.duration.Duration


/**
 * Created by rika on 2015/10/24.
 */
class ContainerController extends ApplicationController{

  case class ContainerRequest[A](val server:Server, request:Request[A]) extends WrappedRequest[A](request)

  def list(serverId:Int, status: Int) = (Action andThen ContainerAction(serverId)) { request =>
    implicit val docker = Docker(request.server.ip,request.server.port)
    val messages = Await.result(docker.containers(), Duration.create(10,"second"))
    Ok(html.host.list(Page(0,20,1,messages.map(c => s"Container: $c"))))
  }

  def ContainerAction(serverId:Int) = new ActionRefiner[Request,ContainerRequest] {
    def refine[A](input: Request[A]) = Future.successful {
      Option.apply(new Server(1,"192.168.33.10",4342))
        .map(new ContainerRequest(_,input))
        .toRight(NotFound)
    }
  }
}

