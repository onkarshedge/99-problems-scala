object P39 {
  def listPrimesInRange(range: Range): Stream[Int] = {
    P31.primes.dropWhile(_ < range.start).takeWhile(_ <= range.end)
  }
}
