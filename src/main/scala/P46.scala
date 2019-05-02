object P46 {
  def not(a: Boolean): Boolean = a match {
    case true  => false
    case false => true
  }

  def and(a: => Boolean, b: => Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _            => false
  }

  def or(a: => Boolean, b: => Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case _         => false
  }

  def equ(a: => Boolean, b: => Boolean): Boolean = or(and(a, b), and(not(a), not(b)))

  def xor(a: => Boolean, b: => Boolean): Boolean = not(equ(a, b))

  def nor(a: => Boolean, b: => Boolean): Boolean = not(or(a, b))

  def nand(a: => Boolean, b: => Boolean): Boolean = not(and(a, b))

  def impl(a: => Boolean, b: => Boolean): Boolean = or(not(a), b)

  def table2(f: (Boolean, Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] = {
    Iterator(true, false).flatMap(a =>
      Iterator(true, false).map(b => (a, b, f(a, b)))
    ).toList
  }

  def table2o(f: (Boolean, Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] = {
    for {
      a <- List(true, false)
      b <- List(true, false)
    } yield (a, b, f(a, b))
  }

}
