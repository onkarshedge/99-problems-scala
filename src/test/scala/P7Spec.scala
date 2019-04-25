import P7.{_flattenRec, flatten}
import org.scalatest.{FlatSpec, Matchers}

class P7Spec extends FlatSpec with Matchers {
  "P07" should "flatten a List of unknown depth to a single level list 1" in {
    flatten(List(List(1, 18), 2, List(3, List(5, 8)))) shouldBe List(1, 18, 2, 3, 5, 8)
    _flattenRec(List(List(1, 18), 2, List(3, List(5, 8)))).reverse shouldBe List(1, 18, 2, 3, 5, 8)
  }

  "P07" should "flatten a List of unknown depth to a single level list 2" in {
    flatten(List(List(1.3, 2.4), "S", List(List(5, 8)), List("K"))) shouldBe List(1.3, 2.4, "S", 5, 8, "K")
    _flattenRec(List(List(1.3, 2.4), "S", List(List(5, 8)), List("K"))).reverse shouldBe List(1.3, 2.4, "S", 5, 8, "K")
  }

}
