import P50.huffman
import org.scalatest.{FunSpec, Matchers}

class P50Spec extends FunSpec with Matchers {
  describe("P50 huffman codes") {
    it("should return huffman code for each charcter") {
      huffman(List(('a', 45), ('b', 13), ('c', 12), ('d', 16), ('e', 9), ('f', 5)))
    }

    it("should decode the huffman code into original string") {

    }
  }
}
