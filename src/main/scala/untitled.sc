import scala.collection.AbstractSeq
import scala.collection.immutable.Stack

val ints = 1 :: Nil

var s: List[Any] = List(13)
s = 1 :: s
s = "sdf" :: s
s

s.isInstanceOf[List[Any]]

val nos: List[Int] = List(1,2)
nos.isInstanceOf[List[Any]]

val sa: Any = List(12)

// type erasure
val l = List[Int](1, 2, 3)
l.isInstanceOf[List[Int]]
l.isInstanceOf[List[String]]
l.isInstanceOf[List[Boolean]]

val stack: Stack[Int] = Stack(1,2,3)
val list: List[Int] = List(1,2)

// I tried this because both List and Stack Extend AbstractSeq
list.isInstanceOf[AbstractSeq[Any]]
stack.isInstanceOf[AbstractSeq[Any]]

// also read this variances
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

val single = List(1)
single match {
  case Nil => println("nil")
  case h :: t => print(h);print(t); if(t == Nil) println("equals NIl")
}

val (x, y) = (0, 1)

val ls = List(List(1,3))
ls ++ List(List(1,4))
List(5,6,7) :: ls
//vs
ls :: List(5,6,7)

type Onkar = Int
def Onkar(x: Int) = x
def foo(x: Onkar) = x * 3
foo(Onkar(4))

//type runLengthEncoding[A] = (Int, A) | A
//val rls:List[runLengthEncoding[Symbol]] = List((1, 'a), 'b)

//def intToIntToInts: Nothing => Int => List[String] = _ => List.fill(_)("foo")
//val intToStrings = intToIntToInts()
//val strings = intToStrings
//(1 to 4).flatMap(intToIntToInts)





