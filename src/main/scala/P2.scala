import java.util.NoSuchElementException

object P2 {
  // P02: return second last element in the list
  //  xs.init.last
  /*def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }*/
  def penultimate[A](xs: List[A]): A = {
    if (xs.length <= 1) throw new NoSuchElementException
    var these = xs
    var rest = xs.tail
    while (rest.length > 1) { //length is 0(n)
      these = rest
      rest = rest.tail
    }
    these.head
  }
}
