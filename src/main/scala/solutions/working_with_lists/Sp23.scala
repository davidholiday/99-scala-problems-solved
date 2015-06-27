package solutions.working_with_lists

/**
 * 
 * P23 (**) Extract a given number of randomly selected elements from a list.
 * Example:
 *
 * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 * res0: List[Symbol] = List('e, 'd, 'a)
 *
 * Hint: Use the solution to problem P20
 * 
 * jun '15 david holiday
 */

class Sp23 {
  
  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
  
  def getSolution: solutionT = {
    randomSelect(3, input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( )
  }
  
  
  def randomSelect(num: Int, input: List[Symbol]): List[Symbol] = {
    
  }
  
  
}