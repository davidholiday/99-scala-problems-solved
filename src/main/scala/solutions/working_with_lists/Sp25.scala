package solutions.working_with_lists

import solutions._

/**
 * scala problem 25 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 * 
 * P25 (*) Generate a random permutation of the elements of a list.
 * Hint: Use the solution of problem P23.
 *  
 *  Example:
 *  
 *  scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 *  res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 *  
 *  jul '15 david holiday
 */
class Sp25 extends SpMeta {
  
  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'e, 'f)
  
  def getSolution: solutionT = {
    randomPermute(input)
  }

  
  def checkSolution(solution: solutionT): Unit = {
    //logger.info(solution + "")
    
    // ensure solution is the correct size
    assert(solution.size == input.size)   
    
    // ensure each each call to randomPermute creates a unique result
    solution should not equal randomPermute(input) 
    
  }

  
  def randomPermute(inputL:List[Symbol]): List[Symbol] = {
    new Sp23 randomSelect(inputL.size, inputL)
  }
 
  
}