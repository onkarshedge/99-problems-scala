import P41.{goldbachList, printGoldbachListLimited}
import org.scalatest.{FunSpec, Matchers}

class P41Spec extends FunSpec with Matchers {
  describe("P41 goldbachList") {
    it("should return a list of even numbers within range with their goldbach composition") {
      goldbachList(9 to 20) shouldBe
        List(
          (10, (3, 7)),
          (12, (5, 7)),
          (14, (3, 11)),
          (16, (3, 13)),
          (18, (5, 13)),
          (20, (3, 17))
        )
    }
  }

  describe("P41 printGoldbachListLimited") {
    it("should return a list of even numbers within range with their goldbach composition") {
      printGoldbachListLimited(2 to 2000, 50) shouldBe
        List(
          (992, (73, 919)),
          (1382, (61, 1321)),
          (1856, (67, 1789)),
          (1928, (61, 1867))
        )
    }
  }
}
