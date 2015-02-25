package solutions.working_with_lists

import solutions._

/**
 * scala problem 05 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P05 (*) Reverse a list.
 *   Example:
 *
 *  scala> reverse(List(1, 1, 2, 3, 5, 8))
 *  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 *
 * feb'15 david holiday
 *
 */

class Sp05 extends SpMeta {

  type inputT = List[Int]
  type solutionT = List[Int]

  val input = List(1, 1, 2, 3, 5, 8)

  def getSolution: solutionT = {
    input.reverse
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == List[Int](8, 5, 3, 2, 1, 1))
  }

}
