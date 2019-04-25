import scala.collection.mutable.ListBuffer

object P19 {
  // P19
  //  def rotate[A](n: Int, ls: List[A]): List[A] = {
  //    val nBounded = if (ls.isEmpty) 0 else n % ls.length
  //    if (nBounded < 0) rotate(nBounded + ls.length, ls)
  //    else (ls drop nBounded) ::: (ls take nBounded)
  //  }
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    def leftRotateR(n: Int, lb: ListBuffer[A]): List[A] = {
      (n, lb) match {
        case (_, ListBuffer()) => Nil
        case (0, _)            => lb.toList
        case (c, b)            => leftRotateR(c - 1, b.tail += b.head)
      }
    }

    def rightRotateR(n: Int, lb: ListBuffer[A]): List[A] = {
      (n, lb) match {
        case (_, ListBuffer()) => Nil
        case (0, _)            => lb.toList
        case (c, b)            => rightRotateR(c - 1, b.+=:(b.last).dropRight(1))
      }
    }

    if (ls.isEmpty) return ls
    val rotateCount = n % ls.length
    if (rotateCount > 0) leftRotateR(rotateCount, ls.to[ListBuffer])
    else rightRotateR(-rotateCount, ls.to[ListBuffer])
  }
}
