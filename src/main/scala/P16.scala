object P16 {
  // P16: drop every Nth element
  // Tail recursive.
  //def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
  //    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
  //      case (_, Nil)       => result.reverse
  //      case (1, _ :: tail) => dropR(n, tail, result)
  //      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
  //    }
  //    dropR(n, ls, Nil)
  //  }
  def drop[A](n: Int, xs: List[A]): List[A] = {
    xs.zipWithIndex.filter(t => (t._2 + 1) % n != 0).map(_._1)
  }
}
