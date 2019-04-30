import P40.goldbach
import org.scalatest.{FunSpec, Matchers}

class P40Spec extends FunSpec with Matchers {
  describe("P40 goldbach") {
    it("should return a composite number as sum of two primes") {
      goldbach(28) shouldBe (5, 23)
    }
  }
}
