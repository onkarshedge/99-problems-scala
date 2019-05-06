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
