import scala.annotation.tailrec

object P32 {
  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (a == 0) return b
    gcd(b % a, a)
  }
}
