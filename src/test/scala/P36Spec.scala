import P36.primeFactorsMultiplicity
import org.scalatest.{FunSpec, Matchers}

class P36Spec extends FunSpec with Matchers {
  describe("P36 primeFactorsMultiplicity") {
    it("should return factors of 315 grouped by count") {
      primeFactorsMultiplicity(315) shouldBe Map(3 -> 2, 5 -> 1, 7 -> 1)
    }
  }
}
