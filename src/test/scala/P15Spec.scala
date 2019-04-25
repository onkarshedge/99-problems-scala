import P15.duplicateN
import org.scalatest.{FlatSpec, Matchers}

class P15Spec extends FlatSpec with Matchers {

  "P15" should "duplicate each element N times" in {
    duplicateN(3, List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  }
}
