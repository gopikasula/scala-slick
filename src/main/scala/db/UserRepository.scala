package db
import connection.{DBComponent,MySqlDBComponent}


trait EmployeeRepoApi extends EmployeeTable {
  this:DBComponent =>
  import driver.api._
  def findEmployeeByName(name:String)={
    db.run(userTableQuery.filter(_.name === name).result.headOption)
  }

  def insertEmployee (name:String,age:Int,email:String)={
    db.run(employeeTableAutoInc += Employee(0,name,age,email))
  }
}

trait EmployeeTable {

  this:DBComponent=>
  import driver.api._

  protected val userTableQuery = TableQuery[EmployeeTable]

  protected def employeeTableAutoInc = userTableQuery.returning(userTableQuery.map(_.id))

  class EmployeeTable(tag: Tag) extends Table[Employee](tag,"users"){
    val id = column[Int]("id", O.PrimaryKey,O.AutoInc)
    val name = column[String]("name")
    val age = column[Int]("age")
    val email = column[String]("email")

    def * = (id,name,age,email) <> (Employee.tupled, Employee.unapply)

  }

}

//class EmployeeRepo extends UserTable with MySqlDBComponent

object EmployeeRepoObj extends EmployeeRepoApi with  MySqlDBComponent

case class Employee(id:Int,name:String,age:Int,email:String)