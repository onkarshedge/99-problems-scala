object P26 {
  // P26 C(N,K) permutations
  def combinations[A](k: Int, ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) return List(Nil)
    if (k <= 1) return ls.map(List(_))
    val res2 = if (k <= ls.tail.length) combinations(k, ls.tail) else Nil
    combinations(k - 1, ls.tail).map(ls.head :: _) ::: res2
  }
}
