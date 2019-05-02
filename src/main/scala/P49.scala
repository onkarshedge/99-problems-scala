object P49 {
  def gray(n: Int): List[String] = {
    if (n == 1) return List("0", "1")
    val strings = gray(n - 1)
    strings.map("0" + _) ::: strings.reverse.map("1" + _)
  }

  import scala.collection.mutable

  private val strings = mutable.Map(0 -> List(""))

  def grayMemoized(n: Int): List[String] = {
    if (!strings.contains(n)) {
      val x = grayMemoized(n - 1) map ("0" + _)
      val y = grayMemoized(n - 1).reverse map ("1" + _)
      strings += (n -> (x ::: y))
    }
    strings(n)
  }
}