package solutions.working_with_lists

import solutions._

/**
 * scala problem 26 of set s-99
 * 
 * P26 (**) Generate the combinations of K distinct objects chosen from the N 
 * elements of a list. In how many ways can a committee of 3 be chosen from a 
 * group of 12 people? We all know that there are C(12,3) = 220 possibilities 
 * (C(N,K) denotes the well-known binomial coefficient). For pure 
 * mathematicians, this result may be great. But we want to really generate all
 * the possibilities.
 *
 *   Example:
 *
 *   scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
 *   res0: List[List[Symbol]] = 
 *   	  List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 * 
 *   
 * aug'15 david holiday
 */


class Sp26 extends SpMeta {

  type inputT = (Int, List[Symbol])
  type solutionT = List[List[Symbol]]
  
  val input = (3, List('a, 'b, 'c, 'd, 'e, 'f))
 
  def getSolution: solutionT = {

  }

  
  def checkSolution(solution: solutionT): Unit = {
    
  }

  
  def combinations(input: inputT): solutionT = {
      
  }
  
  
  
  
}