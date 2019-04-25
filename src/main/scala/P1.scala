import java.util.NoSuchElementException

import scala.annotation.tailrec

object P1 {
  // P01:  Find last element in the list
  /*def last: A = {
    if (isEmpty) throw new NoSuchElementException
    var these = this
    var nx = these.tail
    while (!nx.isEmpty) {
      these = nx
      nx = nx.tail
    }
    these.head
  }*/
  def last[A](xs: List[A]): A = {
    if (xs.isEmpty) throw new NoSuchElementException

    @tailrec
    def _last(xs: List[A]): A = xs match {
      case head :: Nil => head
      case _ :: tail   => _last(tail)
    }

    _last(xs)
  }
}
