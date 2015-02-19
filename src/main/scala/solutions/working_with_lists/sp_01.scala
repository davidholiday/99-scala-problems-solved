
/**
 * scala problem 01 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P01 (*) Find the last element of a list.
 *   Example:
 *
 *   scala> last(List(1, 1, 2, 3, 5, 8))
 *   res0: Int = 8
 *
 * feb'15 david holiday
 *
 */


class sp_01 extends spMeta {
  val testList = List(1, 1, 2, 3, 5, 8)


  def getSolution(): T = {
    testList.last
  }

  def checkSolution(solution: T): Unit = {
    assert(solution == 8)
  }
}