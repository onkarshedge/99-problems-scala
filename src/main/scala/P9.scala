import scala.annotation.tailrec

object P9 {
  // P09: repeated characters into separate sublists
  def packElements[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span {
        _ == ls.head
      }
      if (next == Nil) List(packed)
      else packed :: packElements(next)
    }
  }

  def pack[A](xs: List[A]): List[List[A]] = {
    if (xs.isEmpty) return List(List())

    @tailrec
    def packR(result: List[List[A]], xs: List[A]): List[List[A]] = {
      xs match {
        case h :: tail => packR(result ++ List(xs.takeWhile(xs.head == _)), xs.dropWhile(xs.head == _))
        case Nil       => result
      }
    }

    packR(Nil, xs)
  }
}
