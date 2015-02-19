
/**
 * scala problem 01 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P01 (*) Find the last element of a list.
 *   Example:
 *
 *   scala> last(List(1, 1, 2, 3, 5, 8))
 *   res0: Int = 8
 *
 * feb'15 david holiday
 *
 */


class sp_01 extends spMeta {
  type inputT = List[Int]
  type solutionT = Int

  val input = List(1, 1, 2, 3, 5, 8)


  def getSolution(): solutionT = {
    input.last
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == 8)
  }

}