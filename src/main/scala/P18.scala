object P18 {
  // P18: extract a slice from a list
  //    xs.slice(a, a + b - a)
  //  override def slice(from: Int, until: Int): List[A] = {
  //    val lo = scala.math.max(from, 0)
  //    if (until <= lo || isEmpty) Nil
  //    else this drop lo take (until - lo)
  //  }
  // Since several of the patterns are similar, we can condense the tail recursive
  // solution a little.
  // def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
  //    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
  //      if (curList.isEmpty || count >= end) result.reverse
  //      else sliceR(count + 1, curList.tail,
  //        if (count >= start) curList.head :: result
  //        else result)
  //    }
  //    sliceR(0, ls, Nil)
  //  }
  //
  //  // Functional.
  //  def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =
  //    ls drop s take (e - (s max 0))
  def slice[A](a: Int, b: Int, xs: List[A]): List[A] = {
    def sliceR(res: List[A], currentIndex: Int, xs: List[A]): List[A] = {
      if (xs.isEmpty) return res.reverse
      if (currentIndex >= a && currentIndex < b) sliceR(xs.head :: res, currentIndex + 1, xs.tail)
      else sliceR(res, currentIndex + 1, xs.tail)
    }

    sliceR(Nil, 0, xs)
  }
}
