package solutions.working_with_lists

import solutions.SpMeta

/**
 * scala problem 11 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P11 (*) Modified run-length encoding.
 *   Modify the result of problem P10 in such a way that if an element has no
 *   duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
 *
 *   Example:
 *
 *   scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e,
 *   'e, 'e, 'e))
 *   res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 *
 * feb'15 david holiday
 *
 *
 */


class Sp11 extends SpMeta {
  type inputT = List[Symbol]
  type solutionT = List[Any]

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def getSolution: solutionT = {
    new Sp10 splitAndGroup(input) map { t => if (t._1 == 1) t._2 else t }
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)) )
  }

// ** this was my solution before looking at the provided answer. I like the
// given answer better.
//
//
//  def splitAndGroup(input: inputT): solutionT = {
//    input.span(_ == input.head)
//
//    if (input.isEmpty) List()
//    else {
//      val (expandedElement, nextSet) = input.span(_ == input.head)
//      val packedElement = getPackedElement(expandedElement)
//      if (nextSet == Nil) List(packedElement)
//      else packedElement :: splitAndGroup(nextSet)
//    }
//
//  }
//
//
//  def getPackedElement(expandedElement:inputT): Any = {
//    if (expandedElement.length == 1) return expandedElement(0)
//    else return (expandedElement.length, expandedElement.head)
//  }


}