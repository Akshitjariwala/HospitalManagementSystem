package DatabaseLayer.ActionDatabase.Patient.Login;

import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientLoginDAO implements IPatientLoginDAO {

  private Connection connection = null;
  private IDatabaseConnection databaseConnection;
  private IDatabaseConnectionFactory databaseConnectionFactory;
  private Statement statement = null;

  public PatientLoginDAO() {

    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public String getLoginCredentials(String userID) {

    String providedPassword = "";
    ResultSet resultSet = null;

    try {
      connection = databaseConnection.openDBConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery("SELECT password FROM login_cred WHERE userid='" + userID + "';");
      while (resultSet.next()) {
        providedPassword = resultSet.getString(1);
      }
    } catch (SQLException e) {
      System.out.println("SQL ERROR 1");
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return providedPassword;
  }

  public String getPatientName(String userID) {

    String patientName = "";
    ResultSet resultSet = null;

    try {
      connection = databaseConnection.openDBConnection();
      statement = connection.createStatement();
      String queryToGetPatientName = "SELECT CONCAT(first_name,' ',last_name) FROM patients where patient_id='" + userID + "';";
      resultSet = statement.executeQuery(queryToGetPatientName);
      while (resultSet.next()) {
        patientName = resultSet.getString(1);
      }
    } catch (SQLException e) {
      System.err.println("SQL ERROR 2");
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return patientName;
  }
}
