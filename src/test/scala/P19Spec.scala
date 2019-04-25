import P19.rotate
import org.scalatest.{FlatSpec, Matchers}

class P19Spec extends FlatSpec with Matchers {

  "P19" should "left rotate the list by N if positive" in {
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  }

  "P19" should "right rotate the list by N if negative" in {
    rotate(-3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) shouldBe
      List('i, 'j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)
  }

}
