/**
 * testrunner for 99 scala problem solutions.
 *
 * 99 problems found here:: http://aperiodic.net/phil/scala/s-99/
 *
 * FEB'15 David Holiday
 */

import java.io.File
import org.apache.commons.io.FilenameUtils
import org.slf4j.LoggerFactory


object bootStrap {
  val logger = LoggerFactory.getLogger(this.getClass.getSimpleName)

  /**
   * bootstraps program
   */
    def main(args: Array[String]): Unit = {

      // go through solution files and execute
      for (fName <- getSolutionFiles(new File("./src/main/scala"))) {
        val fNameNoExtS = FilenameUtils.removeExtension(fName.getName)
        logger.info("processing: " + fNameNoExtS)
        solutionRunner(fNameNoExtS)
      }

    }


  /**
   * takes the filename, converts it into an object and runs the 'solution'
   * method.
   *
   * @param name - string representation of file name, minus the extension
   */
    def solutionRunner(name: String): Unit = {
      // create instances of class, class object, and solution method
      val classLoader = this.getClass.getClassLoader
      val clazz = classLoader.loadClass(name)
      val solutionMethod = clazz.getDeclaredMethod("solution")

      // execute solution method
      solutionMethod.invoke(clazz.newInstance)
    }



  /**
   * trolls through working directory and all sub directories in search of files
   * with names starting with "sp_" ('sp' for 'scala problem'). thanks to
   * stack overflow for base code: http://stackoverflow.com/questions/2637643/
   * how-do-i-list-all-files-in-a-subdirectory-in-scala
   *
   * @param f - java File object
   * @return targetFileList - Array[java.io.File] - list of file objects
   *         that have names starting with "sp_"
   */
    def getSolutionFiles(f: File): Array[File] = {
      // create lists of files, directories, and target files
      val fullFileList = f.listFiles
      val targetFileList = fullFileList.filter(_.getName.matches("^sp_.*"))
      val dirList = fullFileList.filter(_.isDirectory)

      // recursively append target files located in sub directories to list.
      // return populated list to caller.
      targetFileList ++ dirList.flatMap(getSolutionFiles)
    }


}




