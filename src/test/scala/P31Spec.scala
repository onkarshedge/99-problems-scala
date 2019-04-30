import P31.IntegerPrime
import org.scalatest.{FunSpec, Matchers}

class P31Spec extends FunSpec with Matchers {
  describe("P31 isPrime") {
    it("should return true for 7") {
      7.isPrime shouldBe true
    }
    it("should return false for 9") {
      9.isPrime shouldBe false
    }
    it("should return true for 2") {
      2.isPrime shouldBe true
    }
    it("should return true for 223") {
      223.isPrime shouldBe true
    }
    it("should return false for 289") {
      289.isPrime shouldBe false
    }
  }


}
