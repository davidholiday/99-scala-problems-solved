package solutions.working_with_lists

import solutions._

/**
 * scala problem 19 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P20 (*) Remove the Kth element from a list.
 *   Return the list and the removed element in a Tuple. Elements are numbered 
 *   from 0.
 *
 *   Example:
 *
 *   scala> removeAt(1, List('a, 'b, 'c, 'd))
 *   res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 *
 *  mar'15 david holiday
 *
 */

class Sp20 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = (List[Symbol], Symbol)

  val input = List('a, 'b, 'c, 'd)
  
  def getSolution: solutionT = {
    removeAt(1, input)
  }

  def checkSolution(solution: solutionT): Unit = {

    assert(       
      solution == (List('a, 'c, 'd),'b)
    )

  }


  def removeAt(i: Int, inputL: inputT): solutionT = {
    // grab the element to be removed
    val dumpVal = inputL(i)
    
    // grab list size
    val listSize = inputL.size
    
    // create a tuple comprised of the two halves of the list 
    // minus the kth element, and the kth element.
    (inputL.take(i) ++ inputL.takeRight(listSize - i - 1), dumpVal)  
  }
  




}