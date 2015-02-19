
/**
 * scala problem 02 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P02 (*) Find the last but one element of a list.
 *   Example:
 *
 *   scala> penultimate(List(1, 1, 2, 3, 5, 8))
 *   res0: Int = 5
 *
 * feb'15 david holiday
 *
 */

class sp_02 extends spMeta {
  type inputT = List[Int]
  type solutionT = Int

  val input = List(1, 1, 2, 3, 5, 8)

  def getSolution(): solutionT = {
    val listSizeI = input.length
    input(listSizeI -2)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == 5)
  }

}