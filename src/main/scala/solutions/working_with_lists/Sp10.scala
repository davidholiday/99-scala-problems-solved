package solutions.working_with_lists

import solutions._


/**
 * scala problem 10 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P10 (*) Run-length encoding of a list.
 *   Use the result of problem P09 to implement the so-called run-length
 *   encoding data compression method. Consecutive duplicates of elements are
 *   encoded as tuples (N, E) where N is the number of duplicates of the element
 *   E.
 *
 *   Example:
 *
 *   scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *   res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d),
 *   (4,'e))
 *
 * feb'15 david holiday
 *
 *
 */


class Sp10 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[(Int, Symbol)]

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def getSolution: solutionT = {
    splitAndGroup(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) )
  }

  def splitAndGroup(input: inputT): solutionT = {
    input.span(_ == input.head)

    if (input.isEmpty) List()
    else {
      val (expandedElement, nextSet) = input.span(_ == input.head)
      val packedElement = (expandedElement.length, expandedElement.head)
      if (nextSet == Nil) List(packedElement)
      else packedElement :: splitAndGroup(nextSet)
    }

  }

}