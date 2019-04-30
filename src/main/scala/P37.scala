import P36.primeFactorsMultiplicity

object P37 {

  def totient(n: Int): Int = {
    primeFactorsMultiplicity(n).map(t => (t._1 - 1) * Math.pow(t._1, t._2 - 1).toInt).product
  }

//  def totient1(n:Int): Int = primeFactorsMultiplicity(n).foldLeft(1) { (r, f) =>
  //    f match { case (p, m) => r * (p - 1) * Math.pow(p, m - 1).toInt }
  //  }

}
