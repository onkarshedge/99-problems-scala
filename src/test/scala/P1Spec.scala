import P1.last
import org.scalatest.{FlatSpec, Matchers}

class P1Spec extends FlatSpec with Matchers {
  "P01" should "return last element of a List" in {
    last(List(1, 5, 6)) should be(6)
  }

  "P01" should "return last element of a single element List" in {
    last(List(5)) should be(5)
  }

  "P01" should "throw exception if list is empty" in {
    a[NoSuchElementException] shouldBe thrownBy {
      last(List())
    }
  }

}
