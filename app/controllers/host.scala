package controllers

import help.Page
import play.api.mvc.{ Action, Controller }
import views.html

/**
 * Created by rika on 2015/10/24.
 */
class Host extends Controller{
  def list(page: Int) = Action { implicit request =>
    Ok(html.host.list(Page(0,20,1,List("192.168.137.33"))))
  }
}
