import scala.runtime.RichBoolean

object P47 {

  implicit class RichBoolean(a: Boolean) {

    def and(b: => Boolean): Boolean = (a, b) match {
      case (true, true) => true
      case _            => false
    }

    def or(b: => Boolean): Boolean = (a, b) match {
      case (true, _) => true
      case (_, true) => true
      case _         => false
    }

    def equ(b: => Boolean): Boolean = (a and b) or (not(a) and not(b))

    def xor(b: => Boolean): Boolean = not(a equ b)

    def nor(b: => Boolean): Boolean = not(a or b)

    def nand(b: => Boolean): Boolean = not(a and b)

    def impl(b: => Boolean): Boolean = not(a) or b

  }

  def table2(f: (Boolean, Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] = {
    for {
      a <- List(true, false)
      b <- List(true, false)
    } yield (a, b, f(a, b))
  }

  def not(a: Boolean): Boolean = a match {
    case true  => false
    case false => true
  }
}

object S99Logic {
  implicit def boolean2S99Logic(a: Boolean): RichBoolean = new RichBoolean(a)
}
