import org.scalatest.{FunSpec, Matchers}

class P59Spec extends FunSpec with Matchers {
  describe("P59 height balanced trees") {
    it("the count should be 1 for height 1") {
      Tree.hBalanced(1, "x").length shouldBe 1
    }
    it("count should be 3 for height 2") {
      val list = Tree.hBalanced(2, "x")
      list shouldBe
        List(
          Node("x", Node("x", End, End), Node("x", End, End)),
          Node("x", Node("x", End, End), End),
          Node("x", End, Node("x", End, End))
        )

    }
    it("count should be 9 for height 3") {
      Tree.hBalanced(3, "x").length shouldBe 9
    }
  }
}
