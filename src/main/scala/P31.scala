object P31 {

  implicit class IntegerPrime(n: Int) {
    def isPrime: Boolean = n > 1 && !((2 to Math.sqrt(n).toInt) exists (n % _ == 0))
  }

  //  **************************************************
  def isPrime(n: Int): Boolean = (n > 1) && (primes takeWhile {
    _ <= Math.sqrt(n)
  } forall {
    n % _ != 0
  })

  val primes = Stream.cons(2, Stream.from(3, 2) filter {
    isPrime
  })

  //************************************************
  def calculatePrimesStream(end: Int): Stream[Int] = {
    val odds = Stream.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
    val composites = odds.flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))
    Stream.from(3, 2).takeWhile(_ <= end).diff(composites)
  }


  //  ***************************************************
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0)) //> sieve: (s: Stream[Int])Stream[Int]

  val primes1 = sieve(from(2)) //> primes  : Stream[Int] = Stream(2, ?)

}
