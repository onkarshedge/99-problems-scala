object P22 {
  // P22
  // The classic functional approach would be to use `unfoldr`, which Scala
  // doesn't have.  So we'll write one and then use it.
  //  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
  //    f(s) match {
  //      case None         => Nil
  //      case Some((r, n)) => r :: unfoldRight(n)(f)
  //    }
  //  def rangeFunctional(start: Int, end: Int): List[Int] =
  //    unfoldRight(start) { n =>
  //      if (n > end) None
  //      else Some((n, n + 1))
  //    }
  def range(start: Int, end: Int): List[Int] = {
    List.range(start, end + 1)
  }
}
