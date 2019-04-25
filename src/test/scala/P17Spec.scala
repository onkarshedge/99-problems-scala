import P17.splitTR
import org.scalatest.{FlatSpec, Matchers}

class P17Spec extends FlatSpec with Matchers {

  "P17" should "split a list into parts" in {
    splitTR(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }

}
