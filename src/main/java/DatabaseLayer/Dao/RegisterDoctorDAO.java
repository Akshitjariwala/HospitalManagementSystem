/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterDoctorDAO implements IRegisterDoctorDAO {

  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public RegisterDoctorDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  /* The details of the doctor can be added
   * The details are added by using SQL query
   */
  public int addDoctor(Doctor doct) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);
    int status = 0;
    try {

      String insertQuery = "INSERT INTO  doctors VALUES ('" + doct.getId() + "','" + doct.getMedicalLicenseId() + "', '" + doct.getPassword() + "','" +
              doct.getLastName() + "', '" + doct.getFirstName() + "','" + doct.getMiddleName() + "', " +
              "'" + doct.getEmailId() + "', '" + doct.getPhoneNumber() + "' ," +
              " '" + doct.getAddress() + "' ,'" + doct.getCity() + "' , " +
              "'" + doct.getState() + "', '" + doct.getExperience() + "','" + doct.getSpecialization() + "', " +
              "'" + doct.getDepartment() + "')";

      status = statement.executeUpdate(insertQuery);  //if successful status should return 1
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return status;
  }


}
