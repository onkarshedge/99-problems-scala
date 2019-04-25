import P23.randomSelect
import org.scalatest.{FlatSpec, Matchers}

class P23Spec extends FlatSpec with Matchers {

  "P23" should "randomly select elements from a list" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }

}
