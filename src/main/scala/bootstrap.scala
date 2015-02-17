/**
 * testrunner for 99 scala problem solutions.
 *
 * 99 problems found here:: http://aperiodic.net/phil/scala/s-99/
 *
 * FEB'15 David Holiday
 */

import java.io.File

object bootStrap {

    def main(args: Array[String]): Unit = {

      for (fName <- getFileList(new File("./src/main/resources"))) {
        println(fName.getName )
      }

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
    def getFileList(f: File): Array[File] = {
      // get file list, filter that list by checking filename against regex
      val targetFileList = f.listFiles().filter(_.getName().matches("^sp_.*"))

      // get a list of subdirectories in current directory
      val dirList = f.listFiles.filter(_.isDirectory)

      for (dName <- dirList) {
        println("searching for solutions in directory: " + dName)
      }

      targetFileList ++ f.listFiles.filter(_.isDirectory).flatMap(getFileList)
    }


    def getFileListTwo(f: File): Array[File] = {
      val targetFileListAll


    }


}




