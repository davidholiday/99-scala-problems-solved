package solutions.working_with_lists

import solutions._
import org.scalatest._
import Matchers._

/**
 * 
 * P23 (**) Extract a given number of randomly selected elements from a list.
 * Example:
 *
 * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 * res0: List[Symbol] = List('f, 'd, 'a)
 *
 * Hint: Use the solution to problem P20
 * 
 * jun '15 david holiday
 * 
 * 
 * 
 * *NOTE* just discovered scalaTest!
 * http://www.scalatest.org/
 */
class Sp23 extends SpMeta {
    
  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
  val selectNum = 3;
  
  def getSolution: solutionT = {
    randomSelect(selectNum, input)
  }

  // checks for size and randomness 
  def checkSolution(solution: solutionT): Unit = {
    assert(solution.size == selectNum)    
    solution should not equal randomSelect(selectNum, input)  
  }
  
  
  // uses Sp24 lotto method to create a random list of indicies then
  // activates buildRandomList to do the heavy lifting
  def randomSelect(num: Int, input: List[Symbol]): List[Symbol] = {
    val randomIndexList = new Sp24 lotto(num, input.size)
    buildRandomList(randomIndexList.size - 1,
                    randomIndexList, 
                    input)
  }
  
  
  // takes the random index list and creates the random
  // symbol list
  def buildRandomList(count: Int, 
                      indexList: List[Int], 
                      symbolList: List[Symbol]): List[Symbol] = {
    
    // if num = zero, stop and roll data into list
    if (count < 0) Nil
    else {
      symbolList(indexList(count)) :: 
          buildRandomList(count-1, indexList, symbolList)
    }
     
  }

  
  
  
  
  
}