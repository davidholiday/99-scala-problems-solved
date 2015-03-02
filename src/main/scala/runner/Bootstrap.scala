package runner

import java.io.File

import org.apache.commons.io.FilenameUtils

/**
 * testrunner for 99 scala problem solutions.
 *
 * 99 problems found here:: http://aperiodic.net/phil/scala/s-99/
 *
 * FEB'15 David Holiday
 */




object Bootstrap extends Logger {

  /**
   * bootstraps program
   */
    def main(args: Array[String]): Unit = {

      // go through solution files and execute
      for (file <- getSolutionFiles(new File("./src/main/scala"))) {
        val fQclassName = makeFqClassName(file)
        logger.info("processing: " + fQclassName)
        solutionRunner(fQclassName)
      }

    }


  /**
   * takes a file object and returns a string representing the fully qualified
   * class name represented by that file.
   *
   * @param file
   * @return string representation of the fully qualified class name
   */
  def makeFqClassName(file: File): String = {
    // pull out the file name - we'll use this for our class name
    val fNameNoExtS = FilenameUtils.removeExtension(file.getName)

    // extract only the path
    val fPathOnlyS =
      file.getPath.substring(0, file.getPath.lastIndexOf(File.separator))

    // create a list of the path name, minus the delimiter
    val fPathDelimList: List[String] = fPathOnlyS.split("/").toList

    // truncate the list to include on the class name info
    val fqNameList: List[String] =
      fPathDelimList.drop(fPathDelimList.lastIndexOf("solutions"))

    // convert the list to a string representation of a class name and return
    // to caller
    fqNameList.mkString(".") + "." + fNameNoExtS
  }


  /**
   * does the same thing as makeFqClassName2 - this in response to my SE query:
   * http://codereview.stackexchange.com/
   *  questions/82615/file-to-fully-qualified-class-name-function/82849#82849
   *
   * from user:
   * http://codereview.stackexchange.com/users/50769/vertere
   *
   * regarding ways to refactor makeFqClassName more scala-tastic. i like what
   * this code is doing so i'm leaving it in here, even though it's never
   * called. the only issue is that if, for some reason, the Spxx files are
   * nested more deeply in the directory structure, this function won't pick
   * it up.
   *
   * @param file
   * @return
   */
  def makeFqClassName2(file: File): String = {
    val fileName :: _ = file.getName.split('.').toList
    val upDir :: upUpDir :: _ =
      file.getParent.split(File.separator(0)).toList.reverse
    s"$upUpDir.$upDir.$fileName"
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
      val solutionMethod =
          clazz.getSuperclass.getDeclaredMethod("solveAndCheck")

      // execute solution method
      solutionMethod.invoke(clazz.newInstance)
    }



  /**
   * trolls through working directory and all sub directories in search of files
   * with names starting with "sp_" ('sp' for 'scala problem'). thanks to
   * Thanks to user {@link http://stackoverflow.com/users/247533/rex-kerr
   * Rex-Kerr} for base code:
   * http://stackoverflow.com/questions/2637643/
   * how-do-i-list-all-files-in-a-subdirectory-in-scala
   *
   * @param f - java File object
   * @return targetFileList - Array[java.io.File] - list of file objects
   *         that have names starting with "sp_"
   */
    def getSolutionFiles(f: File): Array[File] = {
      // create lists of files, directories, and target files
      val fullFileList = f.listFiles
      val targetFileList = fullFileList.filter(_.getName.matches("^Sp[0-9]+.*"))
      val dirList = fullFileList.filter(_.isDirectory)

      // recursively append target files located in sub directories to list.
      // return populated list to caller.
      targetFileList ++ dirList.flatMap(getSolutionFiles)
    }


}




