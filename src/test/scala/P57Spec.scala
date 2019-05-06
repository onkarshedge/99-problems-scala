import org.scalatest.{FunSpec, Matchers}

class P57Spec extends FunSpec with Matchers {
  describe("BST Tree") {
    it("should store less than nodes in left and greater in right in an immutable way") {
      var n: BST[Int] = null
      val node: BSTNode[Int] = BSTNode(5)
      n = node.+=(3)
      n = n.+=(9)
      n = n.+=(4)

      // adding same element
      n = n.+=(9)

      println(n)
      println(node)

      node shouldBe Node(5, BSTEnd, BSTEnd)

      n shouldBe
        Node(5,
          Node(3,
            BSTEnd,
            Node(4, BSTEnd, BSTEnd)
          ),
          Node(9, BSTEnd, BSTEnd)
        )

      // this should also work, but End and BSTEnd are not same.
      //      n shouldBe  Node(5,
      //          Node(3,
      //            End,
      //            Node(4, End, End)
      //          ),
      //          Node(9, End, End)
      //        )
    }
    it("should create a BST from a list") {
      BST.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric shouldBe true
      BST.fromList(List(3, 2, 5, 7, 4)).isSymmetric shouldBe false
    }
  }
}
