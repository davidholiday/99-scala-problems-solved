package solutions.working_with_lists

import solutions._

/**
 * scala problem 13 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P13 (**) Run-length encoding of a list (direct solution).
 *   Implement the so-called run-length encoding data compression method
 *   directly. I.e. don't use other methods you've written (like P09's pack);
 *   do all the work directly.
 *
 *   Example:
 *
 *   scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e,
 *   'e, 'e))
 *   res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d),
 *   (4,'e))
 *
 *  feb'15 david holiday
 *
 */

class Sp13 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[(Int, Symbol)]

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def getSolution: solutionT = {
    pack2(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) )
  }

  def pack2(input: inputT): solutionT = input match {
    case Nil => Nil
    case e => {
      val (headSequence, tail) = input span { _ == input.head }
      (headSequence.length, headSequence.head) :: pack2(tail)
    }

  }

}
