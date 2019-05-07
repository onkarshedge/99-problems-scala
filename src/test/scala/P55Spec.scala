import org.scalatest.{FunSpec, Matchers}

class P55Spec extends FunSpec with Matchers {
  // abs(Count of left subtree nodes - count of right subtree nodes) is <= 1 at each node
  // The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one
  // at each node this should hold true
  describe("P55 cbalnaced") {
    it("should generate list of trees for odd number") {
      Tree.cBalanced(3, "x").length shouldBe 1
    }
    it("should generate list of trees for even number") {
      Tree.cBalanced(4, "x").length shouldBe 4
    }
  }
}
