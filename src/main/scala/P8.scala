object P8 {
  // P08: repeated characters replace with one
  // dropWhile
  /*def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }*/
  /*def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }*/
  def compress(xs: List[Any]): List[Any] = xs match {
    case Nil          => Nil
    case _ :: Nil     => xs
    case head :: tail =>
      val compressedTail = compress(tail)
      if (head == compressedTail.head) compressedTail else head :: compressedTail
  }
}
