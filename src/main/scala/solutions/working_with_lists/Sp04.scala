package solutions.working_with_lists

import solutions.SpMeta

/**
 * scala problem 04 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P04 (*) Find the number of elements of a list.
 *   Example:
 *
 *   scala> length(List(1, 1, 2, 3, 5, 8))
 *   res0: Int = 6
 *
 * feb'15 david holiday
 *
 */

class Sp04 extends SpMeta {

  type inputT = List[Int]
  type solutionT = Int

  val input = List(1, 1, 2, 3, 5, 8)

  def getSolution: solutionT = {
    input.length
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == 6)
  }

}
