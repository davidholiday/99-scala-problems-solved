package solutions.working_with_lists

import solutions._

/**
* P25 (*) Generate a random permutation of the elements of a list.
* Hint: Use the solution of problem P23.
*
* Example:
*
* scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
* res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
*
* jun '15 david holiday
*
*/
class Sp25 extends SpMeta {
  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'b, 'c, 'd, 'e, 'f)
  
  def getSolution: solutionT = {
    randomPermute(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( )
  }
  
  
  def randomPermute(input: List[Symbol]): List[Symbol] = {
    
  }
  
  
}


