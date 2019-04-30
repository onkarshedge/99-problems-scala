import P39.listPrimesInRange
import org.scalatest.{FunSpec, Matchers}

class P39Spec extends FunSpec with Matchers {
  describe("P39 list primes in range") {
    it("should") {
      listPrimesInRange(7 to 31) shouldBe List(7, 11, 13, 17, 19, 23, 29, 31)
    }
  }
}
