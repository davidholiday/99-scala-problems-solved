package runner

/**
 * simple logging trait
 * feb '15 david holiday
 */
import org.slf4j.LoggerFactory

trait Logger {
  val logger = LoggerFactory.getLogger(this.getClass.getSimpleName)
}
