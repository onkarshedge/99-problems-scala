import P49._
import org.scalatest.{FunSpec, Matchers}

class P49Spec extends FunSpec with Matchers {
  describe("P49 gray codes") {
    it("should change only one bit at a time") {
      gray(1) shouldBe List("0", "1")
      gray(2) shouldBe List("00", "01", "11", "10")
      gray(3) shouldBe List("000", "001", "011", "010", "110", "111", "101", "100")
    }

    it("graymemoized should change only one bit at a time") {
      grayMemoized(1) shouldBe List("0", "1")
      grayMemoized(2) shouldBe List("00", "01", "11", "10")
      grayMemoized(3) shouldBe List("000", "001", "011", "010", "110", "111", "101", "100")
    }
  }
}
