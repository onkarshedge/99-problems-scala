import P26.combinations
import org.scalatest.{FlatSpec, Matchers}

class P26Spec extends FlatSpec with Matchers {

  "P26" should "generate combinations of a list with chosen k" in {
    println(combinations(1, List('a, 'b, 'c, 'd)))
    println(combinations(2, List('a, 'b, 'c, 'd)))
    println(combinations(3, List('a, 'b, 'c, 'd)))
    println(combinations(4, List('a, 'b, 'c, 'd)))
    println(combinations(4, List('a)))
  }
}
