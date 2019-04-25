import P2.penultimate
import org.scalatest.{FlatSpec, Matchers}

class P2Spec extends FlatSpec with Matchers {
  "P02" should "return second last element of a list" in {
    penultimate(List(3, 1, 4, 5)) shouldBe 4
  }

  "P02" should "return second last element of a list with 2 elements" in {
    penultimate(List(3, 1)) shouldBe 3
  }

  "P02" should "throw exception if list is empty or less than 2" in {
    a[NoSuchElementException] shouldBe thrownBy {
      penultimate(List(3))
    }
  }
}
