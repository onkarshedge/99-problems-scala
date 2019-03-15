import java.util.NoSuchElementException

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.util.Random

object P1to10 {

  // P01:  Find last element in the list
  /*def last: A = {
    if (isEmpty) throw new NoSuchElementException
    var these = this
    var nx = these.tail
    while (!nx.isEmpty) {
      these = nx
      nx = nx.tail
    }
    these.head
  }*/
  def last[A](xs: List[A]): A = {
    if (xs.isEmpty) throw new NoSuchElementException

    @tailrec
    def _last(xs: List[A]): A = xs match {
      case head :: Nil => head
      case _ :: tail   => _last(tail)
    }

    _last(xs)
  }

  // P02: return second last element in the list
  //  xs.init.last
  /*def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException
  }*/
  def penultimate[A](xs: List[A]): A = {
    if (xs.length <= 1) throw new NoSuchElementException
    var these = xs
    var rest = xs.tail
    while (rest.length > 1) { //length is 0(n)
      these = rest
      rest = rest.tail
    }
    these.head
  }

  // P03: Find the Nth element of a list.
  /*def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _   ) => h
    case (n, _ :: tail) => nthRecursive(n - 1, tail)
    case (_, Nil      ) => throw new IndexOutofBoundsException
  }*/
  // takeRight, takeLeft
  def nth[A](index: Int, xs: List[A]): A = xs(index)


  // P04: Find the length of a list.
  // xs.length
  def length[A](xs: List[A]): Int = {
    @tailrec
    def _length(xs: List[A], count: Int = 0): Int = xs match {
      case Nil => count
      case _   => _length(xs.tail, count + 1)
    }

    _length(xs)
  }

  // P05: Reverse a list.
  // xs.reverse
  /*override def reverse: List[A] = {
    var result: List[A] = Nil
    var these = this
    while (!these.isEmpty) {
      result = these.head :: result
      these = these.tail
    }
    result
  }*/
  def reverse[A](xs: List[A]): List[A] = {
    @tailrec
    def _reverse(xs: List[A], result: List[A] = Nil): List[A] = xs match {
      case Nil          => result
      case head :: tail => _reverse(tail, head :: result)
    }

    _reverse(xs)
  }

  // P06: Find out whether a list is a palindrome.
  def isPalindrome[A](xs: List[A]): Boolean = xs == xs.reverse


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

  // P08: repeated characters replace with one
  // dropWhile
  /*def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }*/
  /*def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }*/
  def compress(xs: List[Any]): List[Any] = xs match {
    case Nil          => Nil
    case _ :: Nil     => xs
    case head :: tail =>
      val compressedTail = compress(tail)
      if (head == compressedTail.head) compressedTail else head :: compressedTail
  }

  // P09: repeated characters into separate sublists
  def packElements[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span {
        _ == ls.head
      }
      if (next == Nil) List(packed)
      else packed :: packElements(next)
    }
  }

  def pack[A](xs: List[A]): List[List[A]] = {
    if (xs.isEmpty) return List(List())

    @tailrec
    def packR(result: List[List[A]], xs: List[A]): List[List[A]] = {
      xs match {
        case h :: tail => packR(result ++ List(xs.takeWhile(xs.head == _)), xs.dropWhile(xs.head == _))
        case Nil       => result
      }
    }

    packR(Nil, xs)
  }

  // P10: run length encoding
  def runLengthEncoding[A](xs: List[A]): List[(Int, A)] = {
    if (xs.isEmpty) return List()
    packElements(xs) map { ls => (ls.length, ls.head) }
  }

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

  // P12: decode of P10
  // make does not work use tabulate
  //  def decode[A](ls: List[(Int, A)]): List[A] =
  //    ls flatMap { e => List.make(e._1, e._2) }
  //  }
  def decode[A](xs: List[(Int, A)]): List[A] = xs.foldLeft(List[A]()) {
    (acc, enc) => acc ++ List.fill(enc._1)(enc._2)
  }

  def decodeEncoding[A](xs: List[(Int, A)]): List[A] = xs.flatMap {
    e => List.fill(e._1)(e._2)
  }

  // P13: encode direct
  def encodeDirect[A](xs: List[A]): List[(Int, A)] = {
    if (xs.isEmpty) Nil
    else {
      val (packed, next) = xs span {
        _ == xs.head
      }
      (packed.length, packed.head) :: encodeDirect(next)
    }

  }

  // P14: duplicate the elements of a list
  //  def duplicate[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }
  def duplicate[A](xs: List[A]): List[A] = xs match {
    case Nil          => Nil
    case head :: tail => head :: head :: duplicate(tail)
  }

  // P15: duplicate the elements of a list N times
  def duplicateN[A](n: Int, xs: List[A]): List[A] = xs flatMap {
    List.fill(n)(_)
  }

  // P16: drop every Nth element
  // Tail recursive.
  //def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
  //    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
  //      case (_, Nil)       => result.reverse
  //      case (1, _ :: tail) => dropR(n, tail, result)
  //      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
  //    }
  //    dropR(n, ls, Nil)
  //  }
  def drop[A](n: Int, xs: List[A]): List[A] = {
    xs.zipWithIndex.filter(t => (t._2 + 1) % n != 0).map(_._1)
  }

  //  var count = n
  //  while (!these.isEmpty && count > 0) {
  //    these = these.tail
  //    count -= 1
  //  }
  //  these

  // P17: split a list into two parts
  //  def splitBuiltin[A](n: Int, ls: List[A]): (List[A], List[A]) = ls.splitAt(n)
  //  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
  //    (ls.take(n), ls.drop(n))
  def split[A](n: Int, xs: List[A]): (List[A], List[A]) = {
    var result: List[A] = Nil
    var count = n
    var rest = xs
    while (count > 0 && !rest.isEmpty) {
      result = rest.head :: result
      rest = rest.tail
      count = count - 1
    }
    (result.reverse, rest)
  }

  def splitR[A](n: Int, xs: List[A]): (List[A], List[A]) = (n, xs) match {
    case (_, Nil)       => (Nil, Nil)
    case (0, _)         => (Nil, xs)
    case (_, h :: tail) =>
      val splitTuple = splitR(n - 1, tail)
      (h :: splitTuple._1, splitTuple._2)
  }

  def splitTR[A](n: Int, xs: List[A]): (List[A], List[A]) = {
    def splitTailR(pre: List[A], n: Int, xs: List[A]): (List[A], List[A]) = {
      (n, xs) match {
        case (_, Nil)       => (pre.reverse, Nil)
        case (0, list)      => (pre.reverse, list)
        case (_, h :: tail) => splitTailR(h :: pre, n - 1, tail)
      }
    }

    splitTailR(Nil, n, xs)
  }

  // P18: extract a slice from a list
  //    xs.slice(a, a + b - a)
  //  override def slice(from: Int, until: Int): List[A] = {
  //    val lo = scala.math.max(from, 0)
  //    if (until <= lo || isEmpty) Nil
  //    else this drop lo take (until - lo)
  //  }
  // Since several of the patterns are similar, we can condense the tail recursive
  // solution a little.
  // def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
  //    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = {
  //      if (curList.isEmpty || count >= end) result.reverse
  //      else sliceR(count + 1, curList.tail,
  //        if (count >= start) curList.head :: result
  //        else result)
  //    }
  //    sliceR(0, ls, Nil)
  //  }
  //
  //  // Functional.
  //  def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =
  //    ls drop s take (e - (s max 0))
  def slice[A](a: Int, b: Int, xs: List[A]): List[A] = {
    def sliceR(res: List[A], currentIndex: Int, xs: List[A]): List[A] = {
      if (xs.isEmpty) return res.reverse
      if (currentIndex >= a && currentIndex < b) sliceR(xs.head :: res, currentIndex + 1, xs.tail)
      else sliceR(res, currentIndex + 1, xs.tail)
    }

    sliceR(Nil, 0, xs)
  }

  // P19
  //  def rotate[A](n: Int, ls: List[A]): List[A] = {
  //    val nBounded = if (ls.isEmpty) 0 else n % ls.length
  //    if (nBounded < 0) rotate(nBounded + ls.length, ls)
  //    else (ls drop nBounded) ::: (ls take nBounded)
  //  }
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    def leftRotateR(n: Int, lb: ListBuffer[A]): List[A] = {
      (n, lb) match {
        case (_, ListBuffer()) => Nil
        case (0, _)            => lb.toList
        case (c, b)            => leftRotateR(c - 1, b.tail += b.head)
      }
    }

    def rightRotateR(n: Int, lb: ListBuffer[A]): List[A] = {
      (n, lb) match {
        case (_, ListBuffer()) => Nil
        case (0, _)            => lb.toList
        case (c, b)            => rightRotateR(c - 1, b.+=:(b.last).dropRight(1))
      }
    }

    if (ls.isEmpty) return ls
    val rotateCount = n % ls.length
    if (rotateCount > 0) leftRotateR(rotateCount, ls.to[ListBuffer])
    else rightRotateR(-rotateCount, ls.to[ListBuffer])
  }

  // P20
  //  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
  //    case (Nil, _) if n < 0 => throw new NoSuchElementException
  //    case (pre, e :: post)  => (pre ::: post, e)
  //    case (pre, Nil)        => throw new NoSuchElementException
  //  }
  def removeAt[A](k: Int, ls: List[A]): (List[A], A) = {
    if (k < 0 || k >= ls.length) throw new NoSuchElementException
    val tuple = ls.splitAt(k)
    (tuple._1 ::: tuple._2.tail, tuple._2.head)
  }

  // P21
  def insertAt[A](el: A, k: Int, ls: List[A]): List[A] = ls.splitAt(k) match {
    case (pre, post) => pre ::: el :: post
  }

  // P22
  // The classic functional approach would be to use `unfoldr`, which Scala
  // doesn't have.  So we'll write one and then use it.
  //  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
  //    f(s) match {
  //      case None         => Nil
  //      case Some((r, n)) => r :: unfoldRight(n)(f)
  //    }
  //  def rangeFunctional(start: Int, end: Int): List[Int] =
  //    unfoldRight(start) { n =>
  //      if (n > end) None
  //      else Some((n, n + 1))
  //    }
  def range(start: Int, end: Int): List[Int] = {
    List.range(start, end + 1)
  }

  // P23
  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    val random = new Random()

    def randomSelectR(c: Int, xs: List[A]): List[A] = {
      if (c <= 0) return Nil
      val (rest, el) = removeAt(random.nextInt(xs.length), xs)
      el :: randomSelectR(c - 1, rest)
    }

    randomSelectR(n, ls)
  }

  // P24
  def lotto(n: Int, rangeBound: Int): List[Int] = randomSelect(n, range(1, rangeBound + 1))

  // P25
  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a
  // mutable array.  This is O(n).
  //  def randomPermute[A](ls: List[A]): List[A] = {
  //    val rand = new util.Random
  //    val a = ls.toArray
  //    for (i <- a.length - 1 to 1 by -1) {
  //      val i1 = rand.nextInt(i + 1)
  //      val t = a(i)
  //      a.update(i, a(i1))
  //      a.update(i1, t)
  //    }
  //    a.toList
  //  }
  // Efficient purely functional algorithms for shuffling are a lot harder.  One
  // is described in http://okmij.org/ftp/Haskell/perfect-shuffle.txt using
  // Haskell. Implementing it in Scala is left as an exercise for the reader.
  def randomPermute[A](ls: List[A]): List[A] = randomSelect(ls.length, ls)

  // P26 C(N,K) permutations
  def combinations[A](k: Int, ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) return List(Nil)
    if (k <= 1) return ls.map(List(_))
    val res2 = if (k <= ls.tail.length) combinations(k, ls.tail) else Nil
    combinations(k - 1, ls.tail).map(ls.head :: _) ::: res2
  }

  // P27
  def 

}
