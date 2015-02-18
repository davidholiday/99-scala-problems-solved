/**
 * testrunner for 99 scala problem solutions.
 *
 * 99 problems found here:: http://aperiodic.net/phil/scala/s-99/
 *
 * FEB'15 David Holiday
 */

import java.io.File
import org.apache.commons.io.FilenameUtils


/**
 * boodstraps program
 */
object bootStrap {

    def main(args: Array[String]): Unit = {
      
      // go through solution files and execute
      for (fName <- getSolutionFiles(new File("./src/main/resources"))) {
        println(FilenameUtils.removeExtension(fName.getName))

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
    def getSolutionFiles(f: File): Array[File] = {
      // create lists of files, directories, and target files
      val fullFileList = f.listFiles
      val targetFileList = fullFileList.filter(_.getName.matches("^sp_.*"))
      val dirList = fullFileList.filter(_.isDirectory)

      // recursively append target files located in sub directories to list.
      // return populated list to caller.
      targetFileList ++ dirList.flatMap(getSolutionFiles)
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
   *
             def getFileList(f: File): Array[File] = {
      // get file list, filter that list by checking filename against regex
      val targetFileList = f.listFiles.filter(_.getName.matches("^sp_.*"))

      // get a list of subdirectories in current directory
      val dirList = f.listFiles.filter(_.isDirectory)

      for (dName <- dirList) {
        println("searching for solutions in directory: " + dName)
      }

      targetFileList ++ f.listFiles.filter(_.isDirectory).flatMap(getFileList)
    }
   */









}




