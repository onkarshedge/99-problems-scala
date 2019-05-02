import P47._
import org.scalatest.{FunSpec, Matchers}

class P47Spec extends FunSpec with Matchers {
  describe("P47 logic and codes") {
    //evaluated should not be printed, call by name
    it("should and, xor, nor, xor, impl, equ") {
      true and true shouldBe true
      false and {println("evaluated");false} shouldBe false

      true or {println("evaluated");true} shouldBe true
      false or true shouldBe true

      true  nand true shouldBe false
      false nor false shouldBe true

      true xor true shouldBe false
      true equ true shouldBe true
      true impl false shouldBe false
    }

    it("should print table for expression") {
      table2((a, b) => a and (a or b)) shouldBe List((true, true, true), (true, false, true), (false, true, false), (false, false, false))
    }
  }
}
