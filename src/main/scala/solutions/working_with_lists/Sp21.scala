package solutions.working_with_lists

import solutions._

/**
 * scala problem 19 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P21 (*) Insert an element at a given position into a list.
 *   Example:
 *
 *   scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
 *   res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 *
 *  mar'15 david holiday
 *
 */

class Sp21 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd)
  
  def getSolution: solutionT = {
    insertAt('new, 1, input)
  }

  def checkSolution(solution: solutionT): Unit = {

    assert(       
      solution == List('a, 'new, 'b, 'c, 'd)
    )

  }

  // pretty much the same as Sp20 - break the list apart by index
  // and smoosh it back together with the new addition inserted
  def insertAt(what:Symbol, where:Int, input:inputT): List[Symbol] = {
    input.take(where) ++ List(what) ++ input.takeRight(input.length - where)
  }



}