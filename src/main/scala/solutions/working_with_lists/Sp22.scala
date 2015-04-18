package solutions.working_with_lists

import solutions._

/**
 * scala problem 19 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P22 (*) Create a list containing all integers within a given range.
 *   Example:
 *
 *   scala> range(4, 9)
 *   res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 *
 *  apr '15 david holiday
 *
 */

class Sp22 extends SpMeta {

  type inputT = List[Int]
  type solutionT = List[Int]

  val input = List(4, 9)
  
  def getSolution: solutionT = {
    range(input(0), input(1))
  }

  def checkSolution(solution: solutionT): Unit = {

    assert(       
      solution == List(4, 5, 6, 7, 8, 9)
    )

  }

  def range(start: Int, end: Int): List[Int] = {
    val endPlus = end + 1
    List.range(start, endPlus)
  }



}