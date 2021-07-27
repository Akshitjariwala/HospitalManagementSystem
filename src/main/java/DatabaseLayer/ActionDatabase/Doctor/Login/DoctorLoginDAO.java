package DatabaseLayer.ActionDatabase.Doctor.Login;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorLoginDAO implements IDoctorLoginDAO {

  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public DoctorLoginDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public int checkDoctorLogin(String id, String password) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String count = null;
    String str = null;

    int status = 0;
    try {
      String CheckLoginQuery = "SELECT doc_id, password, first_name, last_name FROM doctors WHERE doc_id = '" + id + "' " +
              "AND password = '" + password + "'";
      ResultSet rs = statement.executeQuery(CheckLoginQuery);
      while (rs.next()) {
        count = rs.getString("doc_id");
        str = rs.getString("password");

      }
      if (count != null && str != null) {
        status = 1;
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      databaseConnection.closeDBConnection();
    }
    return status;
  }

  public Doctor getDoctor(String id, String password) {
    connection = databaseConnection.openDBConnection();
    Statement statement = null;
    try {
      statement = connection.createStatement();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
    Doctor doc = new Doctor();
    try {
      String getDocQuery = "SELECT id, doc_id, password, first_name, last_name FROM doctors WHERE doc_id = '" + id + "' " +
              "AND password = '" + password + "'";
      ResultSet rs = null;
      if (statement != null) {
        rs = statement.executeQuery(getDocQuery);
      }
      if (rs != null) {
        while (rs.next()) {
          doc.setId(rs.getInt("id"));
          doc.setMedicalLicenseId(rs.getString("doc_id"));
        }
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      databaseConnection.closeDBConnection();
    }
    return doc;
  }
}
