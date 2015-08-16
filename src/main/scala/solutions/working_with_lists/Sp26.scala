package solutions.working_with_lists

import solutions._

/**
 * scala problem 26 of set s-99
 * 
 * P26 (**) Generate the combinations of K distinct objects chosen from the N 
 * elements of a list. In how many ways can a committee of 3 be chosen from a 
 * group of 12 people? We all know that there are C(12,3) = 220 possibilities 
 * (C(N,K) denotes the well-known binomial coefficient). For pure 
 * mathematicians, this result may be great. But we want to really generate all
 * the possibilities.
 *
 *   Example:
 *
 *   scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
 *   res0: List[List[Symbol]] = 
 *   	  List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 * 
 *   
 * aug'15 david holiday
 */


class Sp26 extends SpMeta {

  type inputT = (Int, List[Symbol])
  type solutionT = List[List[Symbol]]
  
  val input = (3, List('a, 'b, 'c, 'd, 'e, 'f))
 
  /**
   * There are many ways to enumerate k combinations. One way is to visit all 
   * the binary numbers less than 2^n. Choose those numbers having k nonzero 
   * bits. The positions of these 1 bits in such a number is a specific 
   * k-combination of the set {1,...,n}
   * 
   * 2^6 = 64
   * 
   * 
   * 
   * 
   */
  
  
  
  def getSolution: solutionT = {
    combinations(input)
  }

  
  def checkSolution(solution: solutionT): Unit = {
    
  }

  
  def combinations(input: inputT): solutionT = {
      val listSizeI = input._2.size
      val twoToTheN = scala.math.pow(2, listSizeI).toInt;
      
      // create a list of sequential numbers from one to 2^listSize
      // convert the members of that list to a set of normalized binary strings
      // filter out all the ones who don't have exactly three '1s
      val combinationMaskL = List.range(1, twoToTheN)
        .map { x => normalizeToLength(x.toBinaryString, listSizeI) }
          .filter { x => getOnesCount(x) == 3 }
      
      
      
      
      logger.info(combinationMaskL.size + "")   
          
      logger.info(combinationMaskL + "")
      
      return List(List('a))
  }
  
  
  /**
   * returns the number of ones in a normalized binary string. 
   * thank you SO: http://stackoverflow.com/a/8910767
   * 
   */
  def getOnesCount(asBinaryNormalized: String): Int = {
    asBinaryNormalized.length - asBinaryNormalized.replace("0", "").length
  }
  

  /**
   * normalizes a binary string to a given length. 
   * thank you SO: http://stackoverflow.com/a/2807731/2234770
   */
  def normalizeToLength(asBinaryRaw:String, normalizedLength:Int): String = {
    val sizeDiffI = normalizedLength - asBinaryRaw.length()
    new String(new Array[Char](sizeDiffI)).replace('\0', '0') + asBinaryRaw
  }
  
  
}




