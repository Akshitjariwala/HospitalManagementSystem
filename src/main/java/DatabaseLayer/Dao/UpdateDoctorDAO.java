package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDoctorDAO implements IUpdateDoctorDAO {

  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public UpdateDoctorDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
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
