import P10.runLengthEncoding
import org.scalatest.{FlatSpec, Matchers}

class P10Spec extends FlatSpec with Matchers {

  "P10" should "run length encoding using P09" in {
    runLengthEncoding(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
  }

}
