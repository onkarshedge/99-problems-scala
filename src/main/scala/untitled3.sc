val fact: Stream[BigInt] =
  1 #:: fact.zipWithIndex.map {
    case (p, x) => {
      println(p, x)
      p * (x + 1)
    }
  }


fact(4)
println(fact.take(8).toList)


val add = (a: Int) => a + 1

def square = (a: Int) => a * a

val x = square andThen add
val y = square compose add
x(4)
y(4)

//doesn't work with def function
//because
//val functions are concrete instances of Function0 through Function22.

//def add  (a: Int) = a + 1
//
//def square (a: Int) = a * a
//
//val x = square andThen add
//val y = square compose add
//x(4)
//y(4)


List(Nil).map(List(1, 2) :: _)

List(1, 2, 3, 4) filterNot List(1, 2).contains

List(1, 2, 3, 4) diff List(1, 2)

3.7.toInt
