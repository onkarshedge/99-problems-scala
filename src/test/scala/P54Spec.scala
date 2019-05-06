import org.scalatest.{FunSpec, Matchers}

class P54Spec extends FunSpec with Matchers {
  describe("P54 Sample binary tree") {
    println(Node[Char]('a',
      Node('b', Node('d'), Node('e')),
      Node('c', End, Node('f', Node('g'), End))))

  }
}
