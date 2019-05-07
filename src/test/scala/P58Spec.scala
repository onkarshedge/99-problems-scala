import org.scalatest.{FunSpec, Matchers}

class P58Spec extends FunSpec with Matchers {
  describe("P58 symmetric completely balnaced trees") {
    it("the count should be 0 for 4 nodes") {
      Tree.symmetricBalancedTrees(4, "x").length shouldBe 0
    }
    it("count should be 1 for 3") {
      Tree.symmetricBalancedTrees(3, "x") shouldBe
        List(Node("x", Node("x", End, End), Node("x", End, End)))

    }
    it("count should be 2 for 5") {
      Tree.symmetricBalancedTrees(5, "x").length shouldBe 2
    }
  }
}
