object P13 {
  // P13: encode direct
  def encodeDirect[A](xs: List[A]): List[(Int, A)] = {
    if (xs.isEmpty) Nil
    else {
      val (packed, next) = xs span {
        _ == xs.head
      }
      (packed.length, packed.head) :: encodeDirect(next)
    }

  }
}
