object P7 {
  // P07: flatten(List(List(1, 18), 2, List(3, List(5, 8))))
  /*def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }*/
  def flatten(xs: List[Any]): List[Any] = {
    def _flatten(xs: List[Any]): List[Any] = {
      var result: List[Any] = Nil
      for (el <- xs) {
        el match {
          case list: List[_] => result = _flatten(list) ::: result
          case _             => result = el :: result
        }
      }
      result
    }

    _flatten(xs).reverse
  }

  def _flattenRec(xs: List[Any], result: List[Any] = Nil): List[Any] =
    xs match {
      case Nil       => result
      case head :: _ => head match {
        case list: List[Any] => _flattenRec(xs.tail, _flattenRec(list) ::: result)
        case other           => _flattenRec(xs.tail, other :: result)
      }
    }

}
