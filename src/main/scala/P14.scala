object P14 {

  // P14: duplicate the elements of a list
  //  def duplicate[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }
  def duplicate[A](xs: List[A]): List[A] = xs match {
    case Nil          => Nil
    case head :: tail => head :: head :: duplicate(tail)
  }
}
