package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateReportsDAO  {

  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public UpdateReportsDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  /* Once the details are received for which update is required
   * The details are updated using SQL query
   */
  public void updateReport(String str, int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String updateQuery = "UPDATE lab_reports set" + "\t" + str + "\t" + "where rep_id = " + id;
    try {
      statement.executeUpdate(updateQuery);
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
  }

  public Reports getReportsDetails(int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Reports report = new Reports();

    try {
      String selectQuery = "SELECT * from lab_reports where rep_id = '" + id + "' ";
      ResultSet rs = statement.executeQuery(selectQuery);
      while (rs.next()) {
        report.setReportId(rs.getInt("rep_id"));
        report.setDoctorId(rs.getInt("doc_id"));
        report.setPatientId(rs.getString("patient_id"));
        report.setDiagnosisName(rs.getString("diagnosis_name"));
        report.setDate(rs.getString("date"));
        report.setTestResult(rs.getString("test_result"));
        report.setTestType(rs.getString("test_type"));
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      databaseConnection.closeDBConnection();
    }
    return report;
  }

}
