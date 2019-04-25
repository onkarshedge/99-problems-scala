import P10.runLengthEncoding

object P11 {
  // P11: modified run length encoding
  // Curry Howard isomorphism
  //https://stackoverflow.com/questions/3508077/how-to-define-type-disjunction-union-types
  //type runLengthEncoding[A] = (Int, A) | A
  //val rls:List[runLengthEncoding[Symbol]] = List((1, 'a), 'b)
  def modifiedRunLengthEncoding[A](xs: List[A]): List[Any] = {
    if (xs.isEmpty) return List()
    runLengthEncoding(xs) map { t => if (t._1 == 1) t._2 else t }
  }

  //List(Right((4,'a)), Left('b), Right((2,'c)), Right((2,'a)), Left('d), Right((4,'e))) was not equal to
  //List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  def encodeModified[A](xs: List[A]): List[Either[A, (Int, A)]] = {
    if (xs.isEmpty) return List()
    runLengthEncoding(xs) map { t => if (t._1 == 1) Left(t._2) else Right(t) }
  }
}
