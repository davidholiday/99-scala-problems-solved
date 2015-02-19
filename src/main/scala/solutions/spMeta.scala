/**
 * root class def for all solution files (sp_* files). gives all solution files
 * access to a logger and forces a common protocol across the entire corpus of
 * solution files.
 *
 * FEB'15 David Holiday
 */
abstract class spMeta extends logging {
  type T


  def solveAndCheck = {
    getSolution
    checkSolution(getSolution)
  }

  def getSolution: T

  def checkSolution(solution: T)
}
