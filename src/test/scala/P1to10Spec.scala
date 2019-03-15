import P1to10._
import org.scalatest.{FlatSpec, Matchers}

class P1to10Spec extends FlatSpec with Matchers {

  "P01" should "return last element of a List" in {
    last(List(1, 5, 6)) should be(6)
  }

  "P01" should "return last element of a single element List" in {
    last(List(5)) should be(5)
  }

  "P01" should "throw exception if list is empty" in {
    a[NoSuchElementException] shouldBe thrownBy {
      last(List())
    }
  }

  "P02" should "return second last element of a list" in {
    penultimate(List(3, 1, 4, 5)) shouldBe 4
  }

  "P02" should "return second last element of a list with 2 elements" in {
    penultimate(List(3, 1)) shouldBe 3
  }

  "P02" should "throw exception if list is empty or less than 2" in {
    a[NoSuchElementException] shouldBe thrownBy {
      penultimate(List(3))
    }
  }

  "P03" should "1 return nth element of a list" in {
    nth(2, List(3, 1, 4, 5)) shouldBe 4
  }

  "P03" should "2 return nth element of a list" in {
    nth(0, List(3, 1)) shouldBe 3
  }

  "P03" should "throw exception if index is out of bounds" in {
    a[IndexOutOfBoundsException] shouldBe thrownBy {
      nth(2, List(3, 1))
    }
  }
  "P07" should "flatten a List of unknown depth to a single level list 1" in {
    flatten(List(List(1, 18), 2, List(3, List(5, 8)))) shouldBe List(1, 18, 2, 3, 5, 8)
    _flattenRec(List(List(1, 18), 2, List(3, List(5, 8)))).reverse shouldBe List(1, 18, 2, 3, 5, 8)
  }

  "P07" should "flatten a List of unknown depth to a single level list 2" in {
    flatten(List(List(1.3, 2.4), "S", List(List(5, 8)), List("K"))) shouldBe List(1.3, 2.4, "S", 5, 8, "K")
    _flattenRec(List(List(1.3, 2.4), "S", List(List(5, 8)), List("K"))).reverse shouldBe List(1.3, 2.4, "S", 5, 8, "K")
  }

  "P08" should "replace repeated elements with just one occurrence" in {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List('a, 'b, 'c, 'a, 'd, 'e)
    compress(List('k, 'c, 'd, 'e, 'k)) shouldBe List('k, 'c, 'd, 'e, 'k)
    compress(List('a, 'a, 'a, 'a, 'a)) shouldBe List('a)
  }

  "P09" should "group repeated elements into lists" in {
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    pack(List()) shouldBe
      List(List())

  }

  "P10" should "run length encoding using P09" in {
    runLengthEncoding(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
  }

  "P11" should "run length encoding using P10 with single element as it is" in {
    modifiedRunLengthEncoding(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
  }

  "P11" should "with type safety to some extreme" in {
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List(Right((4, 'a)), Left('b), Right((2, 'c)), Right((2, 'a)), Left('d), Right((4, 'e)))
  }

  "P12" should "decode the encoded list in P10" in {
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldBe
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }

  "P13" should "direct runtime encoding" in {
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encodeDirect(List()) shouldBe
      List()
  }

  "P14" should "duplicate each element once" in {
    duplicate(List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

  "P15" should "duplicate each element N times" in {
    duplicateN(3, List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  }

  "P16" should "drop every Nth item" in {
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }

  "P17" should "split a list into parts" in {
    splitTR(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }

  "P18" should "take a slice from a list" in {
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('d, 'e, 'f, 'g)
  }

  "P19" should "left rotate the list by N if positive" in {
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  }

  "P19" should "right rotate the list by N if negative" in {
    rotate(-3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('i, 'j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)
  }

  "P20" should "remove the kth element" in {
    removeAt(1, List('a, 'b, 'c, 'd)) shouldBe(List('a, 'c, 'd), 'b)
    removeAt(3, List('a, 'b, 'c, 'd)) shouldBe(List('a, 'b, 'c), 'd)
    //    removeAt(2, List()) shouldBe(List(), 'b) exception
  }

  "P21" should "insert element at given index" in {
    insertAt('new, 1, List('a, 'b, 'c, 'd)) shouldBe List('a, 'new, 'b, 'c, 'd)
    insertAt('new, 0, List('a, 'b, 'c, 'd)) shouldBe List('new, 'a, 'b, 'c, 'd)
    insertAt('new, 4, List('a, 'b, 'c, 'd)) shouldBe List('a, 'b, 'c, 'd, 'new)
    insertAt('new, -1, List('a, 'b, 'c, 'd)) shouldBe List('new, 'a, 'b, 'c, 'd)
    insertAt('new, 6, List('a, 'b, 'c, 'd)) shouldBe List('a, 'b, 'c, 'd, 'new)
  }

  "P23" should "randomly select elements from a list" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }

  "P24" should "lotto from 1 to M" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }

  "P25" should "generate permutations of a list" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomPermute(List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }

  "P26" should "generate combinations of a list with chosen k" in {
    println(combinations(1, List('a, 'b, 'c, 'd)))
    println(combinations(2, List('a, 'b, 'c, 'd)))
    println(combinations(3, List('a, 'b, 'c, 'd)))
    println(combinations(4, List('a, 'b, 'c, 'd)))
    println(combinations(4, List('a)))
  }


}
