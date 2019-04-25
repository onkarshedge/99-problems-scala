import scala.util.Random
import P20.removeAt

object P23 {
  // P23
  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    val random = new Random()

    def randomSelectR(c: Int, xs: List[A]): List[A] = {
      if (c <= 0) return Nil
      val (rest, el) = removeAt(random.nextInt(xs.length), xs)
      el :: randomSelectR(c - 1, rest)
    }

    randomSelectR(n, ls)
  }
}
