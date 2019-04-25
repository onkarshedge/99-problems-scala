import P25.randomPermute
import org.scalatest.{FlatSpec, Matchers}

class P25Spec extends FlatSpec with Matchers {

  "P25" should "generate permutations of a list" in {
    List('a, 'b, 'c, 'd, 'f, 'g, 'h) should contain allElementsOf randomPermute(List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }
}
