import org.scalatest.{FunSpec, Matchers}

class P62Spec extends FunSpec with Matchers {
  describe("P62 leave nodes list") {
    it("should return internal nodes") {
      Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList shouldBe List('a', 'c')
    }
  }

}
