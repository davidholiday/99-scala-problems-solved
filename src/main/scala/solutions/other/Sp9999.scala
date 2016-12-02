package solutions.other

import solutions._
import scala.collection.mutable.ListBuffer

/**
 * Question 1 - Anagrams
 * Write a function to determine if two strings of unknown length (but not 
 * longer than 100 MB each) are anagrams of each other, that is, contain 
 * exactly the same number of each letter of the alphabet. It should be case 
 * insensitive, should ignore all characters but the 26 letters of the English 
 * alphabet, should be very time-efficient, and should be space-efficient. 
 * Include a brief explanation of why and how it works efficiently. Include 
 * tests if you have time.
 * 
 * 
 * David Holiday
 * 
 * 
 */
class Sp9999 extends SpMeta {
  
  type inputT = List[(String, String)]
  type solutionT = List[Boolean]

  // valid anagram - tests lower case function
  val input1a = "untidy"
  val input1b = "nuDity"
  
  // valid anagram - tests rejection of non-alpha characters 
  val input2a = "untidy@1"
  val input2b = "nudity1"
  
  // invalid anagram
  val input3a = "finklepuss78"
  val input3b = "untidyuntidy"
  
  // input to be fed into 
  val input = List((input1a, input2a), (input2a, input2b), (input3a, input3b));

  
  /*
   * transmutes the input into the solution to the stated problem.
   */
  def getSolution: solutionT = {    
    val solution = ListBuffer[Boolean]()
    input.map(x => solution.append(compareStrings(x)))
    return solution.toList;
  }

  
  /*
   * homogenizes a pair of strings then checks to see if they have the same
   * number of symbol types by comparing their sums. 
   */
  def compareStrings(inputTuple:(String, String)): Boolean = {

	  val processedStringList1 = inputTuple._1
			  .par
        .filter {x => x.toString() matches "([a-z])"}
			  .map(x => x.toLower)		  
	      .toList

	  val processedStringList2 = inputTuple._2
	      .par
        .filter {x => x.toString() matches "([a-z])"}
	      .map(x => x.toLower)      
	      .toList

	  if (processedStringList1.length == processedStringList2.length) {
		  return (processedStringList1.par.sum.equals(processedStringList2.par.sum))
	  }
	  else {
		  return false
	  }                     

	  
  }

  
  /*
   * ensures the computed solution is correct.
   */
  def checkSolution(solution: solutionT): Unit = {
    assert(solution == List(true, true, false))
  }
  
  
   
}


