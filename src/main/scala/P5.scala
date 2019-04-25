import scala.annotation.tailrec

object P5 {
  // P05: Reverse a list.
  // xs.reverse
  /*override def reverse: List[A] = {
    var result: List[A] = Nil
    var these = this
    while (!these.isEmpty) {
      result = these.head :: result
      these = these.tail
    }
    result
  }*/
  def reverse[A](xs: List[A]): List[A] = {
    @tailrec
    def _reverse(xs: List[A], result: List[A] = Nil): List[A] = xs match {
      case Nil          => result
      case head :: tail => _reverse(tail, head :: result)
    }

    _reverse(xs)
  }
}
