object P12 {
  // P12: decode of P10
  // make does not work use tabulate
  //  def decode[A](ls: List[(Int, A)]): List[A] =
  //    ls flatMap { e => List.make(e._1, e._2) }
  //  }
  def decode[A](xs: List[(Int, A)]): List[A] = xs.foldLeft(List[A]()) {
    (acc, enc) => acc ++ List.fill(enc._1)(enc._2)
  }

  def decodeEncoding[A](xs: List[(Int, A)]): List[A] = xs.flatMap {
    e => List.fill(e._1)(e._2)
  }
}
