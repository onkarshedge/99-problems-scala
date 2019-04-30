import P33.isCoprime

object P34 {
  def totient(a: Int): Int = (1 to a).count(isCoprime(_, a))
}
