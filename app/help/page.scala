package help

/**
 * Created by rika on 2015/10/24.
 */
case class Page[A](total:Int, offset:Int, page:Int, items: Seq[A]) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
  lazy val totalPage = Option(totoal)
}
