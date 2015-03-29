package solutions.working_with_lists

import solutions._

/**
 * scala problem 18 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P18 (**) Extract a slice from a list.
 *   Given two indices, I and K, the slice is the list containing the elements 
 *   from and including the Ith element up to but not including the Kth element
 *    of the original list. Start counting the elements with 0.
 *
 *   Example:
 *
 *   scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *   res0: List[Symbol] = List('d, 'e, 'f, 'g)
 *
 *  mar'15 david holiday
 *
 */

class Sp18 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def getSolution: solutionT = {
    slice(3, 7, input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(       
      solution == List('d, 'e, 'f, 'g)
    )

  }


  def slice(i: Int, k: Int, inputL: inputT): solutionT = {
    // split the list twice -- taking care to update 'k' as it's being applied
    // to a list that's shorter than the original
    inputL.splitAt(i)._2.splitAt(k - i)._1
  }




}