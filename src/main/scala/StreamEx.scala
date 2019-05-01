object StreamEx {

  val fib: Stream[BigInt] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail).map {
    t => t._1 + t._2
  }))

  val fib1: Stream[BigInt] = 0 #:: fib.scan(1: BigInt)(_ + _)

  val fact: Stream[BigInt] =
    1 #:: fact.zipWithIndex.map {
      case (p, x) =>
        println(p, x)
        p * (x + 1)
    }

  val W: Stream[BigInt] = Stream.cons(BigInt(0), W.map(_ + 1))

  val N: Stream[BigInt] = Stream.cons(BigInt(1), N.map(_ + 1))

  val fact1: Stream[BigInt] = Stream.cons(1, fact1.zip(W).map(a => a._1 * (a._2 + 1)))

  val fact2: Stream[BigInt] = N.scan(BigInt(1)){
    (acc, n) => acc * n
  }
}
