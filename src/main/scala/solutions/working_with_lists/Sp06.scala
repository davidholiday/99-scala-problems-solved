package solutions.working_with_lists

import solutions._

/**
 * scala problem 06 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P06 (*) Find out whether a list is a palindrome.
 *   Example:
 *
 *   scala> isPalindrome(List(1, 2, 3, 2, 1))
 *   res0: Boolean = true
 *
 * feb'15 david holiday
 *
 */


class Sp06 extends SpMeta {

  type inputT = List[Int]
  type solutionT = Boolean

  val input = List(1, 2, 3, 2, 1)

  def getSolution: solutionT = {
    // create sublists out of the first and last half of the input list.
    // if list length is odd, this still works because putting the answer into
    // an Int container gives us the rounded-down whole number.
    // reverse the order of the second list and check for equality.
    val listLengthI = input.length
    val compListLengthI = listLengthI / 2: Int
    val firstHalfL = input.drop(compListLengthI)
    val lastHalfReversedL = input.dropRight(compListLengthI).reverse
    firstHalfL.equals(lastHalfReversedL)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert(solution == true)
  }

}
