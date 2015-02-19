/**
 * Created by snerd on 2/18/15.
 */
import org.slf4j.LoggerFactory

trait logging {
  val logger = LoggerFactory.getLogger(this.getClass.getSimpleName)
}
