import P13.encodeDirect
import org.scalatest.{FlatSpec, Matchers}

class P13Spec extends FlatSpec with Matchers {

  "P13" should "direct runtime encoding" in {
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encodeDirect(List()) shouldBe
      List()
  }

}
