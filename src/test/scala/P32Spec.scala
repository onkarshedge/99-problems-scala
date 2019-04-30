import P32.gcd
import org.scalatest.{FunSpec, Matchers}

class P32Spec extends FunSpec with Matchers {
  describe("P31 isPrime") {
    it("should return 9 for 36,63") {
      gcd(36, 63) shouldBe 9
    }
  }
}
