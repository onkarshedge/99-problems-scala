import org.scalatest.{FunSpec, Matchers}

class P60Spec extends FunSpec with Matchers {
  describe("P60 height balanced trees with number of nodes") {
    describe("minHbalNodes minimum number of nodes for a height balanced tree with height H") {
      it("should return 4 for 3") {
        Tree.minHbalNodesFor(3) shouldBe 4
      }
      it("should return 7 for 4") {
        Tree.minHbalNodesFor(4) shouldBe 7
      }
    }
    describe("minHbalNodes maximum number of nodes for a height balanced tree with height H") {
      it("should return 4 for 6") {
        Tree.maxHbalHeightFor(6) shouldBe 3
      }
      it("should return 5 for 11") {
        Tree.maxHbalHeightFor(11) shouldBe 4
      }
    }
  }
}
