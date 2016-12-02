package solutions.working_with_lists

import solutions.SpMeta


/**
 * scala problem 12 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P12 (**) Decode a run-length encoded list.
 *   Given a run-length code list generated as specified in problem P10,
 *   construct its uncompressed version.
 *
 *   Example:
 *
 *   scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 *   res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e,
 *   'e, 'e, 'e)
 *
 *  feb'15 david holiday
 *
 *  this one turned out to be kinda painful -- tried to do all sorts of weird
 *  things because I didn't realize there were so many ways to create the list
 *  from scratch with multiple values. see 'Creating Collections From Scratch'
 *
 *  http://docs.scala-lang.org/overviews/
 *    collections/creating-collections-from-scratch.html
 *
 *
 */


class Sp12 extends SpMeta {

  type inputT = List[(Int, Symbol)]
  type solutionT = List[Symbol]

  val input = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  def getSolution: solutionT = {
    decode(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution ==
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e) )

  }

  def decode(input: inputT): solutionT =  {
    input flatMap { e => List.fill(e._1) (e._2) }
  }


}