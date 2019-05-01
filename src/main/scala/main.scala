import StreamEx._

object main extends App {
  override def main(args: Array[String]): Unit = {
    super.main(args)

    println(fib.take(6).toList)
    println(fib1.take(6).toList)

    println(fact(4))
    println(fact.take(8).toList)

    println(fact1.take(8).toList)
    println(fact2.take(8).toList)
  }
}
