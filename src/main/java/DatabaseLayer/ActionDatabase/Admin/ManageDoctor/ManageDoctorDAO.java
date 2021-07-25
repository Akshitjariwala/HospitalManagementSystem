package DatabaseLayer.ActionDatabase.Admin.ManageDoctor;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageDoctorDAO implements IManageDoctorDAO {
  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public ManageDoctorDAO() {
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
  /* The details of the doctor for which the details have to be updated should an id is passed
   * The details are fetched by using SQL query
   */
  public Doctor getDoctor(String id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Doctor doct = new Doctor();
    try {

      String query1 = "SELECT * from doctors where doc_id = '" + id + "' LIMIT 1";
      ResultSet rs = statement.executeQuery(query1);
      while (rs.next()) {
        doct.setId(rs.getInt("id"));
        doct.setMedicalLicenseId(rs.getString("doc_id"));
        doct.setPassword(rs.getString("password"));
        doct.setLastName(rs.getString("last_name"));
        doct.setFirstName(rs.getString("first_name"));
        doct.setMiddleName(rs.getString("middle_name"));
        doct.setEmailId(rs.getString("email"));
        doct.setPhoneNumber(rs.getString("phone_number"));
        doct.setAddress(rs.getString("address"));
        doct.setCity(rs.getString("city"));
        doct.setState(rs.getString("state"));
        doct.setExperience(rs.getString("experience_years"));
        doct.setSpecialization(rs.getString("specialization"));
        doct.setDepartment(rs.getString("department"));

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return doct;
  }

  /* Once the particular detail which has to be fetched is given should come here
   * The details are updated using SQL query
   */
  public void updateDoctor(String s, int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    try {
      String updateQuery = "UPDATE doctors set" + "\t" + s + "\t" + "where id = " + id;
      statement.executeUpdate(updateQuery);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
  }
}
