
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

class sp_02 extends logging {
  val testList = List(1, 1, 2, 3, 5, 8)

  def solution(): Unit = {
    val listSizeI = testList.length
    val answerI = testList(listSizeI -2)


    assert(answerI == 5)
  }

}