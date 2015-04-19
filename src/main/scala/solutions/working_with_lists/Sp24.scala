package solutions.working_with_lists

import solutions._

/**
 * scala problem 24 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
 *   Example:
 *
 *   scala> lotto(6, 49)
 *   res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 *
 *  apr '15 david holiday
 *
 */
class Sp24 extends SpMeta {
  type inputT = List[Int]
  type solutionT = List[Int]

  val input = List(6, 49)
  
  def getSolution: solutionT = {
    lotto(input(0), input(1))
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution.length == 6 )
    assert( solution.max < input(1))
  }
  
  // nice clean recursive method for handling this
  def lotto (num:Int, maxVal:Int): List[Int] = {
    // if num = zero, stop and roll data into list
    if (num <= 0) Nil
    else {
      scala.util.Random.nextInt(maxVal) :: lotto(num-1, maxVal)
    }
    
  }
  
  
}


