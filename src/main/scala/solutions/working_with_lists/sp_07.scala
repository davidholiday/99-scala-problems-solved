/**
 * scala problem 07 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P07 (**) Flatten a nested list structure.
 *   Example:
 *
 *   scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 *   res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 *
 * feb'15 david holiday
 *
 */


class sp_07 extends spMeta {

  type inputT = List[Any]
  type solutionT = List[Any]

  val input = List(List(List(1, 1), 2, List(3, List(5, 8))))

  def getSolution(): solutionT = {
    flatten(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List(1, 1, 2, 3, 5, 8) )
  }

  /**
   * this is directly copied from the website. as i understand it, this code
   *  1) takes/returns a list
   *  2) executes the 'flatMap' method using the list parameter
   *  3) if the list entry is a list, recursively call flatten, else,
   *    create a single-item list. flatMap will take all the lists and concat
   *    them into a single list.
   * @param ls
   * @return
   */
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

}