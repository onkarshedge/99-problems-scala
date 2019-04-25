import P14.duplicate
import org.scalatest.{FlatSpec, Matchers}

class P14Spec extends FlatSpec with Matchers {

  "P14" should "duplicate each element once" in {
    duplicate(List('a, 'b, 'c, 'c, 'd)) shouldBe List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  }

}
