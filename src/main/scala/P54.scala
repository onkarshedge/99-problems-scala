sealed trait Tree[+T] {
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
}

case object End extends Tree[Nothing] {
  override def toString = "."

  override def isMirrorOf[B](other: Tree[B]): Boolean = other == End

  override def isSymmetric: Boolean = true
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}


trait BST[+T] extends Tree[T] {
  def +=[B >: T : Ordering](v: B): BST[B]
}

// how do I avoid this code duplication ?
case object BSTEnd extends BST[Nothing] {
  override def toString = "."

  override def isMirrorOf[B](other: Tree[B]): Boolean = other == BSTEnd

  override def isSymmetric: Boolean = true

  override def +=[B >: Nothing : Ordering](v: B): BST[B] = BSTNode(v)
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
