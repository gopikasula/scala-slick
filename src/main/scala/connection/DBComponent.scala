package connection
import slick.jdbc.JdbcProfile
trait DBComponent {
  val driver:JdbcProfile
  import  driver.api.Database
  val db:Database
}
