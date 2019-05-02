import P46._
import org.scalatest.{FunSpec, Matchers}

class P46Spec extends FunSpec with Matchers {
  describe("P46 logic and codes") {
    //evaluated should not be printed, call by name
    it("should and, xor, nor, xor, impl, equ") {
      and(true, true) shouldBe true
      and(false, {
        println("evaluated");
        false
      }) shouldBe false

      or(true, {
        println("evaluated");
        true
      }) shouldBe true
      or(false, true) shouldBe true

      nand(true, true) shouldBe false
      nor(false, false) shouldBe true

      xor(true, true) shouldBe false
      equ(true, true) shouldBe true
      impl(true, false) shouldBe false
    }

    it("should print table for expression") {
      table2((a, b) => and(a, or(a, b))) shouldBe List((true, true, true), (true, false, true), (false, true, false), (false, false, false))
    }
  }
}
