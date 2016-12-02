package solutions.working_with_lists

import solutions._

/**
 * scala problem 15 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P15 (**) Duplicate the elements of a list a given number of times.
 *   Example:
 *
 *   scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
 *   res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c,
 *   'c, 'd, 'd, 'd)
 *
 *  mar'15 david holiday
 *
 */

class Sp15 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'c, 'd)

  def getSolution: solutionT = {
    duplicateN(3, input)
  }

  def checkSolution(solution: solutionT): Unit = {

    assert(
      solution==List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    )

  }


  def duplicateN(n: Int, inputL: inputT): solutionT = n match {

    case n if (n > 0) => {
      inputL flatMap { e => List.fill(n)(e) }
    }

  }




}
