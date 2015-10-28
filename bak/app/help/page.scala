package help

/**
 * Created by rika on 2015/10/24.
 */
case class Page[A](total:Int = 0, per:Int = 20, page:Int = 1, items: Seq[A]) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => ( per * page + items.size) < total)
  lazy val totalPage = (total / per) + 1
  lazy val offset = per * (page - 1)
}
