import scala.collection.mutable.{ArrayBuffer, ListBuffer}
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

class TestStruct {
  private val g: ArrayBuffer[String] = ArrayBuffer[String]()

  def add(s: String) = {
    g.+=(s)
    // I will have to explicitly add return type as Unit
    //    () also this returns a Unit type
  }

  def print(): Unit = {
    g.foreach(println(_))
  }
}

val struct = new TestStruct
val ss = struct.add("hello")
ss.+=("world")
struct.print()
// mutating a private collection outside ???