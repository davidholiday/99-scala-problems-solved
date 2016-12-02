package solutions.working_with_lists

import solutions._

/**
 * scala problem 19 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P19 (**) Rotate a list N places to the left.
 *   Examples:
 *
 *   scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *   res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
 *
 *   scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *   res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 *
 *  mar'15 david holiday
 *
 */

class Sp19 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  
  def getSolution: solutionT = {
    rotate(3, input)
    //rotate(-2, input)
  }

  def checkSolution(solution: solutionT): Unit = {

    assert(       
      solution == List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
      //solution == List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    )

  }


  def rotate(i: Int, inputL: inputT): solutionT = {
  
    // check for negative index
    val index = if (i > -1) i else inputL.length + i

    // split the list, swap the pieces, and append
    val splitInputTP = inputL.splitAt(index)
    splitInputTP._2 ++ splitInputTP._1
  }




}