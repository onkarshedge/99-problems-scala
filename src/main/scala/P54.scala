sealed trait Tree[+T] {
  def leafCount: Int

  def leafList: List[T]

  def internalList: List[T]

  def isMirrorOf[B](other: Tree[B]): Boolean

  def isSymmetric: Boolean
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

  override def toString: String = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

  override def isMirrorOf[B](other: Tree[B]): Boolean = other match {
    case t: Node[B] => left.isMirrorOf(t.right) && right.isMirrorOf(t.left)
    case _          => false
  }

  override def isSymmetric: Boolean = left.isMirrorOf(right)

  override def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _          => left.leafCount + right.leafCount
  }

  override def leafList: List[T] = (left, right) match {
    case (End, End) => List(value)
    case _          => left.leafList ::: right.leafList
  }

  override def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _          => value :: left.internalList ::: right.internalList
  }
}

case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[B](other: Tree[B]): Boolean = other == End

  override def isSymmetric: Boolean = true

  override val leafCount: Int = 0

  override def leafList: List[Nothing] = Nil

  override def internalList: List[Nothing] = Nil
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {

  def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1      => List(End)
    case n if n % 2 == 1 => {
      val subtrees = cBalanced(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    }
    case n if n % 2 == 0 => {
      val lesserSubtrees = cBalanced((n - 1) / 2, value)
      val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
    }
  }

  def symmetricBalancedTrees[T](nodeCount: Int, value: T): List[Tree[T]] = {
    cBalanced(nodeCount, value).filter(_.isSymmetric)
  }

  def hBalanced[T](height: Int, value: T): List[Tree[T]] = height match {
    case n if n < 1 => List(End)
    case 1          => List(Node(value))
    case _          =>
      val subtreeWithLessThan1Height: List[Tree[T]] = hBalanced(height - 1, value)
      val subtreeWithLessThan2Height: List[Tree[T]] = hBalanced(height - 2, value)
      subtreeWithLessThan1Height.flatMap(
        l => subtreeWithLessThan2Height.flatMap(
          r => List(
            Node(value, l, l),
            Node(value, l, r),
            Node(value, r, l),
          )
        )
      )
  }

  // TODO is this same as cBalanced ?
  def hbalTreesWithNodes[T](nodes: Int, value: T): List[Tree[T]] = ???

  // maximum nodes in height balanced tree with height h
  def maxHbalNodesFor(height: Int): Int = Math.pow(2, height).toInt - 1

  // minimum nodes in height H
  def minHbalNodesFor(height: Int): Int = {
    height match {
      case 0 => 0
      case 1 => 1
      case _ => minHbalNodesFor(height - 1) + minHbalNodesFor(height - 2) + 1
    }
  }

  // maximum height H a height-balanced binary tree with N nodes
  def maxHbalHeightFor(nodes: Int): Int = Stream.from(1).takeWhile(minHbalNodesFor(_) <= nodes).last

  // minimum height H a height-balanced binary tree with N nodes
  def minHbalHeightFor(nodes: Int): Int = (Math.log(nodes + 1) / Math.log(2)).ceil.toInt

}

//https://cs.stackexchange.com/questions/54171/is-a-balanced-binary-tree-a-complete-binary-tree
// Difference between complete binary tree, balanced tree (no of nodes: left and right), height balanced tree ( height of left and right)
// full tree

trait BST[+T] extends Tree[T] {
  def +=[B >: T : Ordering](v: B): BST[B]
}

// how do I avoid this code duplication ?
case object BSTEnd extends BST[Nothing] {
  override val leafCount: Int = 0

  override def toString = "."

  override def isMirrorOf[B](other: Tree[B]): Boolean = other == BSTEnd

  override def isSymmetric: Boolean = true

  override def +=[B >: Nothing : Ordering](v: B): BST[B] = BSTNode(v)

  override def leafList: List[Nothing] = Nil

  override def internalList: List[Nothing] = Nil
}

class BSTNode[+T](value: T, left: BST[T], right: BST[T]) extends Node(value, left, right) with BST[T] {

  override def +=[B >: T : Ordering](v: B): BST[B] = {
    val ordering: Ordering[B] = implicitly[Ordering[B]]
    ordering.compare(this.value, v) match {
      case 1  => new BSTNode[B](this.value, left.+=(v), right)
      case -1 => new BSTNode[B](this.value, left, right.+=(v))
      case 0  => this
    }
  }
}

object BSTNode {
  def apply[T](value: T): BSTNode[T] = new BSTNode(value, BSTEnd, BSTEnd)
}

object BST {
  def fromList[T](xs: Seq[T])(implicit ordering: Ordering[T]): BST[T] = {
    xs.foldLeft(BSTEnd: BST[T]) {
      (t, v) => t.+=(v)
    }
  }
}
