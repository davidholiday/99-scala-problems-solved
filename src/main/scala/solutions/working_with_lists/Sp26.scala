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
 * 
 * using the binary method of enumaration -- 
 * see https://en.wikipedia.org/wiki/Combination
 * 
 */

class Sp26 extends SpMeta {
  type inputT = (Int, List[Symbol])
  type solutionT = List[List[Symbol]]
  
  val input = (3, List('a, 'b, 'c, 'd, 'e, 'f))
 
 
  
  def getSolution: solutionT = {
    combinations(input)
  }

  
  def checkSolution(solution: solutionT): Unit = {
    logger.trace(solution + "")
    
    // ensure solution is the correct size
    assert(solution.size == binomialCoefficient(input._2.size, input._1))   
    
    // ensure solution has only unique elements
    assert(solution.distinct.size == solution.size)
  }

  
  /**
   * enumerate all combinations of c(n|k)
   */
  def combinations(input: inputT): solutionT = {
      val kSize = input._1
      val listSizeI = input._2.size
      val twoToTheN = scala.math.pow(2, listSizeI).toInt;
      
      // create a list of sequential numbers from one to 2^listSize
      // convert the members of that list to a set of normalized binary strings
      // filter out all the ones who don't have exactly three '1s
      val combinationMaskL = List.range(1, twoToTheN)
        .map { x => normalizeToLength(x.toBinaryString, listSizeI) }
          .filter { x => getOnesCount(x) == kSize }
     
      // convert binary masks to lists of indexes
      val indexL = 
        combinationMaskL.map { x => comboMaskToIntList(x, x.indexOf('1')) }

      // use list of indexes to create combination enumeration
      indexL.map { x => indexLToSymbolL(x, input._2) }
  }
  
  
  /**
   * returns the number of ones in a normalized binary string. 
   * thank you SO: http://stackoverflow.com/a/8910767
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
  
  
  /**
   * takes a binary string as a mask value and creates a List[Int] containing
   * indices.
   */
  def comboMaskToIntList(mask:String, nextIndexOf: Int): List[Int] = {
    
    if (nextIndexOf == -1) Nil
    else {     
      nextIndexOf :: 
        comboMaskToIntList(mask, mask.indexOf('1', nextIndexOf + 1))
    }  
    
  }
  
  
  /**
   * creates a combination list by matching the index list to the 
   * master symbol list
   */
  def indexLToSymbolL(
      indexL: List[Int], masterSymbolL: List[Symbol]): List[Symbol] = {
      List.tabulate(indexL.length)(x => masterSymbolL(indexL(x)))    
  }
  
  
  /**
   * calculates binomial coefficient
   * t/y rosetta code
   * http://rosettacode.org/wiki/Evaluate_binomial_coefficients#Scala
   */
  def binomialCoefficient(n:Int, k:Int)=fact(n) / (fact(k) * fact(n-k))
  def fact(n:Int):Int=if (n==0) 1 else n*fact(n-1)
  
}




