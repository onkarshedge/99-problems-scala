import P9.pack
import org.scalatest.{FlatSpec, Matchers}

class P9Spec extends FlatSpec with Matchers {
  "P09" should "group repeated elements into lists" in {
    pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    pack(List()) shouldBe
      List(List())

  }

}
