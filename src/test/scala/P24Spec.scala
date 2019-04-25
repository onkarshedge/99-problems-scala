import P23.randomSelect
import org.scalatest.{FlatSpec, Matchers}

class P24Spec extends FlatSpec with Matchers {


  "P24" should "lotto from 1 to M" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }

}
