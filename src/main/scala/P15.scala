object P15 {
  // P15: duplicate the elements of a list N times
  def duplicateN[A](n: Int, xs: List[A]): List[A] = xs flatMap {
    List.fill(n)(_)
  }
}
