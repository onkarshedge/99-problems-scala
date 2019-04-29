import P27.{group, group3}
import org.scalatest.{FlatSpec, Matchers}

class P27Spec extends FlatSpec with Matchers {

  "P27" should "group elements into disjoint sets of 2,3,4" in {
    val result = group3(List("a", "b", "c", "d", "e", "g", "h", "i", "j"))
    println(result)
    println(result.length)
  }
  "P27" should "group elements into disjoint sets" in {
    val result = group(List(2, 3, 4), List("a", "b", "c", "d", "e", "g", "h", "i", "j"))
    println(result)
    println(result.length)
  }

  "P27" should "group elements into disjoint sets for 3" in {
    val result = group(List(1,2), List("a", "b", "c"))
    println(result)
    println(result.length)
  }
}
