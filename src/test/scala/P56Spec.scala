import org.scalatest.{FunSpec, Matchers}

class P56Spec extends FunSpec with Matchers {
  describe("isSymmetric") {
    it("should return true for this 3 node tree") {
      Node('a', Node('b'), Node('c')).isSymmetric shouldBe true
    }
  }
  describe("isMirrorOf") {
    it("should return true ignoring values") {
      Node('a',
        Node('b', Node('d'), Node('e')),
        Node('c',
          End,
          Node('f', Node('g'), End))
      ).isMirrorOf(
        Node('1',
          Node('3',
            Node('6', End, Node('7')),
            End
          ),
          Node('2', Node('5'), Node('4')),
        )
      )
    }
  }
}
