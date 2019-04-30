import P40.goldbach

object P41 {
  val even: Int => Boolean = (n: Int) => n % 2 == 0

  def goldbachList(range: Range): List[(Int, (Int, Int))] = {
    range.filter(i => i > 2 && even(i)).map(x => (x, goldbach(x))).toList
  }

  def printGoldbachListLimited(range: Range, limit: Int): List[(Int, (Int, Int))] = {
    goldbachList(range).filter(t => t._2._1 >= 50 && t._2._2 >= 50)
  }
}
