import P18.slice
import org.scalatest.{FlatSpec, Matchers}

class P18Spec extends FlatSpec with Matchers {

  "P18" should "take a slice from a list" in {
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('d, 'e, 'f, 'g)
  }

}
