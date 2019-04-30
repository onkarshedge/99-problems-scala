import P31.{isPrime, primes}

object P40 {
  def goldbach(compositeNumber: Int): (Int, Int) = {
    primes.takeWhile(_ < compositeNumber).find(p => isPrime(compositeNumber - p)) match {
      case Some(v) => (v, compositeNumber - v)
      case None    => throw new IllegalArgumentException("number must be composite greater than 2")
    }
  }
}
