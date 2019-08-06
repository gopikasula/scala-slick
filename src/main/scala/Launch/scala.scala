package Launch

import db.EmployeeRepoObj

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success,Failure}
object  Lauch extends App {
  val employeeRepo = EmployeeRepoObj
  //Inserting records into database
  Await.result(employeeRepo.insertEmployee("krishna",23,"krishna@gmail.com"),10 seconds)
  Await.result(employeeRepo.findEmployeeByName("gopi"),10 seconds)
}
