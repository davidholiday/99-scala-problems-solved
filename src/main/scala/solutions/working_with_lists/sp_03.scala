/**
 * scala problem 03 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P03 (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 *
 * Example:
 *
 * scala> nth(2, List(1, 1, 2, 3, 5, 8))
 * res0: Int = 2
 *
 * feb'15 david holiday
 *
 */

class sp_03 extends spMeta {

  type inputT = List[Int]
  type solutionT = Int

  val input = List(1, 1, 2, 3, 5, 8)

  def getSolution(): solutionT = {
    input(2)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == 2)
  }

}
