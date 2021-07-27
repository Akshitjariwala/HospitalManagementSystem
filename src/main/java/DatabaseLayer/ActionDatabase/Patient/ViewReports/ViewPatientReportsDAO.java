package DatabaseLayer.ActionDatabase.Patient.ViewReports;

import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewPatientReportsDAO implements IViewPatientReportsDAO {

  private Connection connection = null;
  private IDatabaseConnection databaseConnection;
  private IDatabaseConnectionFactory databaseConnectionFactory;
  private Statement statement = null;
  ResultSet resultSet = null;

  public ViewPatientReportsDAO() {

    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public ResultSet fetchLabReports(String patientID) {

    try {
      connection = databaseConnection.openDBConnection();
      String queryToFetchReports = "SELECT rep_id,diagnosis_name,CONCAT('Dr.',dr.first_name,' ',dr.last_name) as Referred_By,date,test_type,test_result \n" +
              "FROM lab_reports lr join doctors dr on dr.id=lr.doc_id \n" +
              "WHERE lr.patient_id='" + patientID + "';";
      statement = connection.createStatement();
      resultSet = statement.executeQuery(queryToFetchReports);
    } catch (SQLException e) {
      System.err.print("SQL ERROR");
    }
    return resultSet;
  }

}
