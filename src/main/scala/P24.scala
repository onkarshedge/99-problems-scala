import P22.range
import P23.randomSelect

object P24 {
  // P24
  def lotto(n: Int, rangeBound: Int): List[Int] = randomSelect(n, range(1, rangeBound + 1))

}
