package solutions.working_with_lists

import solutions._

/**
 * scala problem 16 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P16 (**) Drop every Nth element from a list.
 *   Example:
 *
 *   scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *   res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 *
 *  mar'15 david holiday
 *
 */

class Sp16 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def getSolution: solutionT = {
    dropN(3, input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(       
      solution == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    )

  }

  // takes a list and returns a new one comprised of the input
  // list - only every nth element is dropped
  def dropN(n: Int, inputL: inputT): solutionT = {
    // zip the list so we have indexing info associated with each
    // element
    val zippedL = inputL.zipWithIndex
    
    // add one to the index value (so the sequence starts at '1' and
    // not '0'. then filter out every third element
    val filteredZL = zippedL.filter { 
      pair => ( (pair._2 + 1) % 3 > 0)
    }
    
    // unzip and return the content part of the resulting tuple
    filteredZL.unzip._1
  }




}
