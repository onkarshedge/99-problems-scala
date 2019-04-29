import P26.combinations

object P27 {
  // Group the elements of a set into disjoint subsets
  // In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
  // Write a function that generates all the possibilities.
  def group3[A](ls: List[A]): List[List[List[A]]] = {
    combinations(2, ls).flatMap(c => {
      val remaining = ls.filter(e => !c.contains(e))
      combinations(3, remaining).flatMap(c1 => {
        val remaining1 = remaining.filter(e => !c1.contains(e))
        combinations(4, remaining1).map(c2 => List(c, c1, c2))
      })
    })
  }

  def group[A](disjointSets: List[Int], ls: List[A]): List[List[List[A]]] = {
    if (disjointSets.isEmpty) return List(Nil)

    combinations(disjointSets.head, ls).flatMap(c => {
      val remaining = ls.filter(e => !c.contains(e))
      group(disjointSets.tail, remaining).map(c :: _)
    })
  }

  //
  //  def group3Sol[A](ls: List[A]): List[List[List[A]]] =
  //    for {
  //      a <- combinations(2, ls)
  //      noA = ls filterNot a.contains
  //      b <- combinations(3, noA)
  //    } yield List(a, b, noA diff b)
  //
  //  def groupSol[A](ns: List[Int], ls: List[A]): List[List[List[A]]] = ns match {
  //    case Nil     => List(Nil)
  //    case n :: ns => combinations(n, ls) flatMap { c =>
  //      group(ns, ls filterNot c.contains) map {c :: _}
  //    }
  //  }

}
