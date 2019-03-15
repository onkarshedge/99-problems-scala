import scala.collection.mutable.ListBuffer
//3 match {
//  case x > 4 => println("less than 3")
//  case _   => println("greater than 2")
//}

val ints = List(1, 2, 34)
var buffer = ints.to[ListBuffer]
buffer += 5
buffer.head
buffer = buffer.tail += buffer.head
buffer

buffer.+=:(buffer.last)


val l: List[Int] = List()
l.to[ListBuffer]

-3 % 7
8 % 7
-8 % 7

//5 % l.length

ints.splitAt(1)