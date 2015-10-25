package controllers

import play.api.mvc.{ Action, Controller }
import views._

/**
 * Created by rika on 2015/10/24.
 */
class Host extends Controller{
  def list(page: Int) = Action { implicit request =>
    List("192.168.137.33").map({ host =>
      Ok(html.list())
    })
  }
}
