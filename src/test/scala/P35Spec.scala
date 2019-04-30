import P35.primeFactors
import org.scalatest.{FunSpec, Matchers}

class P35Spec extends FunSpec with Matchers {
  describe("P35 primeFactors") {
    it("should return factors of 315") {
      primeFactors(315) shouldBe List(3, 3, 5, 7)
    }
  }
}
