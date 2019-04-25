import P8.compress
import org.scalatest.{FlatSpec, Matchers}

class P8Spec extends FlatSpec with Matchers {
  "P08" should "replace repeated elements with just one occurrence" in {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe List('a, 'b, 'c, 'a, 'd, 'e)
    compress(List('k, 'c, 'd, 'e, 'k)) shouldBe List('k, 'c, 'd, 'e, 'k)
    compress(List('a, 'a, 'a, 'a, 'a)) shouldBe List('a)
  }
}
