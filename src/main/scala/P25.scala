import P23.randomSelect
object P25 {
  // P25
  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a
  // mutable array.  This is O(n).
  //  def randomPermute[A](ls: List[A]): List[A] = {
  //    val rand = new util.Random
  //    val a = ls.toArray
  //    for (i <- a.length - 1 to 1 by -1) {
  //      val i1 = rand.nextInt(i + 1)
  //      val t = a(i)
  //      a.update(i, a(i1))
  //      a.update(i1, t)
  //    }
  //    a.toList
  //  }
  // Efficient purely functional algorithms for shuffling are a lot harder.  One
  // is described in http://okmij.org/ftp/Haskell/perfect-shuffle.txt using
  // Haskell. Implementing it in Scala is left as an exercise for the reader.
  def randomPermute[A](ls: List[A]): List[A] = randomSelect(ls.length, ls)
}
