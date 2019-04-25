import P20.removeAt
import org.scalatest.{FlatSpec, Matchers}

class P20Spec extends FlatSpec with Matchers {

  "P20" should "remove the kth element" in {
    removeAt(1, List('a, 'b, 'c, 'd)) shouldBe(List('a, 'c, 'd), 'b)
    removeAt(3, List('a, 'b, 'c, 'd)) shouldBe(List('a, 'b, 'c), 'd)
    //    removeAt(2, List()) shouldBe(List(), 'b) exception
  }


}
