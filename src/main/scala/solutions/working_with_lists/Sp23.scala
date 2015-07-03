package solutions.working_with_lists

import solutions._
//import org.scalatest._
//import Matchers._

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
    //logger.info(solution + " ");
    assert(solution.size == selectNum)    
    solution should not equal randomSelect(selectNum, input)  
  }
  
  
  // builds a random list of indicies within the range alloted by the size 
  // of the input list. then creates the list of elements.
  def randomSelect(num: Int, input: List[Symbol]): List[Symbol] = {    
    val indexSourceList = List.range(0, input.size)  
    val randomIndexList = buildRandomIndexList(num, indexSourceList)
    
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
  
  
  // removes a single element from a list
  // used by buildRandomIndexList to remove elements from the root index list
  def removeIndex(index: Int, list:List[Int]): List[Int] = {
    list diff List(index)
  }
  

  // builds a list of random indexes 
  def buildRandomIndexList(count: Int, 
                           indexSourceList: List[Int]): List[Int] = {
 //logger.info("count is: " + count);   
    if (count < 1) Nil
    else {
      val randyI = scala.util.Random.nextInt(indexSourceList.size)
      val indexI = indexSourceList(randyI)
      
      indexI :: 
        buildRandomIndexList(count - 1, removeIndex(indexI, indexSourceList))
      
    }
    
  }
    
  
}