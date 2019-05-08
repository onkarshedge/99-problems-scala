import org.scalatest.{FunSpec, Matchers}

class P61Spec extends FunSpec with Matchers {
  // i.e one child is node  and other is leaf (that count)
  describe("P61 leave nodes count") {
    it("should return 1") {
      Node('x', Node('x'), End).leafCount shouldBe 1
    }
    it("should return 2") {
      Node('x', Node('x', End, Node('x')), Node("x", Node("x", End))).leafCount shouldBe 2
    }
  }
  describe("P62 leave nodes list") {
    it("should return leaf nodes") {
      Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList shouldBe List('b', 'd', 'e')
    }
  }
}
