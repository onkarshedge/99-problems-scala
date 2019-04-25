object P21 {
  // P21
  def insertAt[A](el: A, k: Int, ls: List[A]): List[A] = ls.splitAt(k) match {
    case (pre, post) => pre ::: el :: post
  }
}
