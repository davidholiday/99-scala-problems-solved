/**
 * scala problem 02 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P02 (*) Find the last but one element of a list.
 *   Example:
 *
 *   scala> penultimate(List(1, 1, 2, 3, 5, 8))
 *   res0: Int = 5
 *
 * feb'15 david holiday
 *
 */

import org.slf4j.LoggerFactory

class sp_02 {
  val logger = LoggerFactory.getLogger(this.getClass.getSimpleName)
  val testList = List(1, 1, 2, 3, 5, 8)

  def solution(): Unit = {
    val listSizeI = testList.length
    val answerI = testList(listSizeI -2)


    assert(answerI == 5)
  }

}