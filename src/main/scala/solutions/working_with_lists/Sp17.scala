package solutions.working_with_lists

import solutions._

/**
 * scala problem 17 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P17 (*) Split a list into two parts.
 *   The length of the first part is given. Use a Tuple for your result.
 *
 *   Example:
 *
 *   scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *   res0: (List[Symbol], List[Symbol]) = 
 *    (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *
 *  mar'15 david holiday
 *
 */

class Sp17 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = (List[Symbol], List[Symbol])

  val input = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def getSolution: solutionT = {
    split(3, input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(       
      solution == (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    )

  }


  def split(n: Int, inputL: inputT): solutionT = {
    inputL.splitAt(n)
  }




}