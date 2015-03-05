package solutions.working_with_lists

import solutions._

/**
 * scala problem 14 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P14 (*) Duplicate the elements of a list.
 *  Example:
 *
 *  scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 *  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 *
 *  mar'15 david holiday
 *
 */

class Sp14 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'c, 'd)

  def getSolution: solutionT = {
    input flatMap { e => List(e, e) }
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd) )
  }



}
