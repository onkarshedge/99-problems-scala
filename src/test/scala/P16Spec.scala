import P16.drop
import org.scalatest.{FlatSpec, Matchers}

class P16Spec extends FlatSpec with Matchers {

  "P16" should "drop every Nth item" in {
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  }
}
