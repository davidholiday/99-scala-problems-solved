package solutions

import runner.Logger
import org.scalatest._
import Matchers._

/**
 * root class def for all solution files (sp_* files). gives all solution files
 * access to a logger and forces a common protocol across the entire corpus of
 * solution files.
 *
 * FEB'15 David Holiday
 */
abstract class SpMeta extends Logger with Matchers {
  type inputT
  type solutionT

  val input: inputT

  def solveAndCheck: Unit = {
    checkSolution(getSolution)
  }

  def getSolution: solutionT

  def checkSolution(solution: solutionT)
}
