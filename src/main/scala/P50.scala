import scala.collection.mutable

// TODO unsolved ...
object P50 {
  def huffman(frequencies: List[(Char, Int)]) = {
    // val sortedFrequencies = frequencies.sortBy(_._2)
    // sortedFrequencies.foreach(println(_))

    // val tuples = List((Some('a'), 4), (None, 4), (Some('b'), 3), (None, 3), (Some('q'), 3), (Some('a'), 1))
    // val sorted = tuples.sorted(minOrdering.reverse)
    // sorted.foreach(println(_))

    val minHeap = new mutable.PriorityQueue[(Option[Char], Int, Boolean)]()(minOrdering)

    minHeap.++=(frequencies.map(f => (Some(f._1), f._2, false)))

    val length = frequencies.length
    for (i <- 1 until length) {
      val smallest = minHeap.dequeue()
      val secondSmallest = minHeap.dequeue()
      var parent = (None, smallest._2 + secondSmallest._2, false)
      if (i == length - 1)
        parent = parent.copy(_3 = true)
      minHeap += parent
      minHeap += smallest.copy(_3 = true)
      minHeap += secondSmallest.copy(_3 = true)
    }

    //    maxHeap.foreach(println(_))
    println("****************")
    while (minHeap.nonEmpty) {
      val head = minHeap.dequeue
      println(head)
    }
  }

  object minOrdering extends Ordering[(Option[Char], Int, Boolean)] {
    override def compare(x: (Option[Char], Int, Boolean), y: (Option[Char], Int, Boolean)): Int = y._3 compare x._3 match {
      case 0 => y._2 compare x._2 match {
        case 0 =>
          if (y._1.isEmpty) {
            if (x._1.isEmpty) {
              0
            }
            else {
              1
            }
          } else {
            if (x._1.isEmpty) {
              -1
            }
            else {
              y._1.get compare x._1.get
            }
          }
        case c => c
      }
      case c => c
    }
  }

}

