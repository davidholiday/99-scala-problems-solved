package solutions.working_with_lists

import solutions._

/**
 * scala problem 09 of set s-99
 * http://aperiodic.net/phil/scala/s-99/
 *
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 *   If a list contains repeated elements they should be placed in separate
 *   sublists.
 *
 *   Example:
 *
 *   scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *   res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c,
 *   'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 *
 * feb'15 david holiday
 *
 * *NOTE* clearly I didn't notice the List[A].span function when I wrote this!
 *
 */


class Sp09 extends SpMeta {

  type inputT = List[Symbol]
  type solutionT = List[List[Symbol]]

  val input = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def getSolution: solutionT = {
    splitIntoSubLists(input)
  }

  def checkSolution(solution: solutionT): Unit = {
    assert( solution == List( List('a, 'a, 'a, 'a), List('b), List('c, 'c),
      List('a, 'a), List('d), List('e, 'e, 'e, 'e)) )
  }

  def splitIntoSubLists(input: inputT): solutionT = input match {
    case Nil => Nil

    // list is non-empty and heterogeneous
    case h :: tail if tail.filterNot(_ == h).nonEmpty => {

      // if head equals tail.head, then we know we have a sequence
      // else process the head element and move along
      if (h == tail.head) {
        val endOfRunLeftI = tail.indexWhere(_ != h)
        val seqDropPointRightI = tail.length - endOfRunLeftI

        // combine head with the full sequence in tail matching head.
        // combine result with result of recursive call to function using
        // remaining elements of tail (everything after the matching sequence)
        // as a parameter.
        (h :: tail.dropRight(seqDropPointRightI)) ::
            splitIntoSubLists(tail.drop(endOfRunLeftI))
      }
      else {
        List(h) :: splitIntoSubLists(tail)
      }

    }

    // list is non-empty and homogeneous
    case h :: tail => {
      List(h::tail)
    }

  }


}