import P31.{isPrime, primes}

import scala.collection.mutable.ListBuffer

object P35 {
  def primeFactors(n: Int): List[Int] = {
    var num = n
    val primeFactors: ListBuffer[Int] = new ListBuffer()
    for (i <- 2 to Math.sqrt(n).toInt) {
      while (num % i == 0) {
        primeFactors += i
        num = num / i
      }
    }
    if (num >= 2)
      primeFactors += num
    primeFactors.toList
  }

  def primeFactors2(n: Int): List[Int] = {
    def primeFactorsR(n: Int, ps: Stream[Int]): List[Int] =
      if (isPrime(n)) List(n)
      else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
      else primeFactorsR(n, ps.tail)

    primeFactorsR(n, primes)
  }

}
