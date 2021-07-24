package DatabaseLayer.Dao;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientLoginDAO  {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;
    private ResultSet resultSet = null;


    public String getLoginCredentials(String userID)  {

      String providedPassword="";
      try {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT password FROM login_cred WHERE userid='" + userID + "';");
        while (resultSet.next()) {
          providedPassword = resultSet.getString(1);
        }
      }catch (SQLException e){
        System.out.println("SQL ERROR");
      }
      return providedPassword;
    }

    public String getPatientName(String userID)  {

      String patientName="";
      try {
        statement = connection.createStatement();
        String queryToGetPatientName = "SELECT CONCAT(first_name,' ',last_name) FROM patients where patient_id='" + userID + "';";
        resultSet = statement.executeQuery(queryToGetPatientName);
        while (resultSet.next()) {
          patientName = resultSet.getString(1);
        }
      } catch (SQLException e) {
         System.out.println("SQL ERROR");
      }
      return patientName;
    }
}
