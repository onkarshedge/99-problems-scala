object P17 {
  //  var count = n
  //  while (!these.isEmpty && count > 0) {
  //    these = these.tail
  //    count -= 1
  //  }
  //  these

  // P17: split a list into two parts
  //  def splitBuiltin[A](n: Int, ls: List[A]): (List[A], List[A]) = ls.splitAt(n)
  //  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
  //    (ls.take(n), ls.drop(n))
  def split[A](n: Int, xs: List[A]): (List[A], List[A]) = {
    var result: List[A] = Nil
    var count = n
    var rest = xs
    while (count > 0 && !rest.isEmpty) {
      result = rest.head :: result
      rest = rest.tail
      count = count - 1
    }
    (result.reverse, rest)
  }

  def splitR[A](n: Int, xs: List[A]): (List[A], List[A]) = (n, xs) match {
    case (_, Nil)       => (Nil, Nil)
    case (0, _)         => (Nil, xs)
    case (_, h :: tail) =>
      val splitTuple = splitR(n - 1, tail)
      (h :: splitTuple._1, splitTuple._2)
  }

  def splitTR[A](n: Int, xs: List[A]): (List[A], List[A]) = {
    def splitTailR(pre: List[A], n: Int, xs: List[A]): (List[A], List[A]) = {
      (n, xs) match {
        case (_, Nil)       => (pre.reverse, Nil)
        case (0, list)      => (pre.reverse, list)
        case (_, h :: tail) => splitTailR(h :: pre, n - 1, tail)
      }
    }

    splitTailR(Nil, n, xs)
  }
}
