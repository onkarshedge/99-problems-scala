import P37.totient
import org.scalatest.{FunSpec, Matchers}

class P37Spec extends FunSpec with Matchers {
  describe("P37 totient") {
    it("should return 4 for 10") {
      totient(10) shouldBe 4
    }
  }
}
