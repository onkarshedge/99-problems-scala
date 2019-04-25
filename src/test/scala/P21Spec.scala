import P21.insertAt
import org.scalatest.{FlatSpec, Matchers}

class P21Spec extends FlatSpec with Matchers {

  "P21" should "insert element at given index" in {
    insertAt('new, 1, List('a, 'b, 'c, 'd)) shouldBe List('a, 'new, 'b, 'c, 'd)
    insertAt('new, 0, List('a, 'b, 'c, 'd)) shouldBe List('new, 'a, 'b, 'c, 'd)
    insertAt('new, 4, List('a, 'b, 'c, 'd)) shouldBe List('a, 'b, 'c, 'd, 'new)
    insertAt('new, -1, List('a, 'b, 'c, 'd)) shouldBe List('new, 'a, 'b, 'c, 'd)
    insertAt('new, 6, List('a, 'b, 'c, 'd)) shouldBe List('a, 'b, 'c, 'd, 'new)
  }

}
