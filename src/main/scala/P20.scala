import java.util.NoSuchElementException

object P20 {

  // P20
  //  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
  //    case (Nil, _) if n < 0 => throw new NoSuchElementException
  //    case (pre, e :: post)  => (pre ::: post, e)
  //    case (pre, Nil)        => throw new NoSuchElementException
  //  }
  def removeAt[A](k: Int, ls: List[A]): (List[A], A) = {
    if (k < 0 || k >= ls.length) throw new NoSuchElementException
    val tuple = ls.splitAt(k)
    (tuple._1 ::: tuple._2.tail, tuple._2.head)
  }
}
