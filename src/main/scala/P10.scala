import P9.packElements
object P10 {
  // P10: run length encoding
  def runLengthEncoding[A](xs: List[A]): List[(Int, A)] = {
    if (xs.isEmpty) return List()
    packElements(xs) map { ls => (ls.length, ls.head) }
  }
}
