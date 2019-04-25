import P12.decode
import org.scalatest.{FlatSpec, Matchers}

class P12Spec extends FlatSpec with Matchers {

  "P12" should "decode the encoded list in P10" in {
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) shouldBe
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  }
}
