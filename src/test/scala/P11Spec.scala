import P11.{encodeModified, modifiedRunLengthEncoding}
import org.scalatest.{FlatSpec, Matchers}

class P11Spec extends FlatSpec with Matchers {

  "P11" should "run length encoding using P10 with single element as it is" in {
    modifiedRunLengthEncoding(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e))
  }

  "P11" should "with type safety to some extreme" in {
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) shouldBe
      List(Right((4, 'a)), Left('b), Right((2, 'c)), Right((2, 'a)), Left('d), Right((4, 'e)))
  }

}
