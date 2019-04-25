import P3.nth
import org.scalatest.{FlatSpec, Matchers}

class P3Spec extends FlatSpec with Matchers {
  "P03" should "1 return nth element of a list" in {
    nth(2, List(3, 1, 4, 5)) shouldBe 4
  }

  "P03" should "2 return nth element of a list" in {
    nth(0, List(3, 1)) shouldBe 3
  }

  "P03" should "throw exception if index is out of bounds" in {
    a[IndexOutOfBoundsException] shouldBe thrownBy {
      nth(2, List(3, 1))
    }
  }
}
