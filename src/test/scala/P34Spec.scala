import P34.totient
import org.scalatest.{FunSpec, Matchers}

class P34Spec extends FunSpec with Matchers {
  describe("P34 totient") {
    it("should return 4 for 10") {
      totient(10) shouldBe 4
    }
  }
}
