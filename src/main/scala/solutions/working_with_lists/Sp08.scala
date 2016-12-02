package solutions.working_with_lists

import solutions.SpMeta

/**
 * scala problem 08 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P08 (**) Eliminate consecutive duplicates of list elements.
 *  If a list contains repeated elements they should be replaced with a
 *  single copy of the element. The order of the elements should not be changed.
 *
 * Example:
 *
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 *
 * feb'15 david holiday
 *
 */


class Sp08 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[Symbol]

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def getSolution: solutionT = {
    compress(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List('a, 'b, 'c, 'a, 'd, 'e) )
  }

  def compress(input: inputT): solutionT = input match {
    case Nil => Nil
    case h :: tail => {
      h :: compress(tail.dropWhile(_ == h))
    }
  }


}