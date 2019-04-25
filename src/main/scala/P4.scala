import scala.annotation.tailrec

object P4 {
  // P04: Find the length of a list.
  // xs.length
  def length[A](xs: List[A]): Int = {
    @tailrec
    def _length(xs: List[A], count: Int = 0): Int = xs match {
      case Nil => count
      case _   => _length(xs.tail, count + 1)
    }

    _length(xs)
  }
}
