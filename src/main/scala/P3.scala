object P3 {
  // P03: Find the Nth element of a list.
  /*def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil      ) => throw new IndexOutofBoundsException
  }*/
  // takeRight, takeLeft
  def nth[A](index: Int, xs: List[A]): A = xs(index)

}
