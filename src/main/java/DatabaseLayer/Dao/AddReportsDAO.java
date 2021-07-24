/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddReportsDAO implements IAddReportsDAO {
  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public AddReportsDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public int addReport(Reports report) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    int status = 0;
    try {

      String insertQuery = "INSERT INTO  lab_reports VALUES ('" + report.getReportId() + "','" + report.getDoctorId() + "', '" +
              report.getPatientId() + "','" + report.getDiagnosisName() + "', '" + report.getDate() + "','" +
              report.getTestResult() + "','" + report.getTestType() + "')";

      //if successful status returns 1
      if (statement != null) {
        status = statement.executeUpdate(insertQuery);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return status;
  }

  /* To add the reports the doctor id is necessary
   * The id should be existing in the doctors table
   * It is matched with the help of query
   */
  public int checkDoctorId(int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    int count = 0;
    try {
      String checkQuery = "SELECT id FROM doctors WHERE id = '" + id + "'";
      ResultSet rs = null;
      if (statement != null) {
        rs = statement.executeQuery(checkQuery);
      }
      if (rs != null) {
        while (rs.next()) {
          count = rs.getInt("id");
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      databaseConnection.closeDBConnection();
    }
    return count;
  }

  /* To add the reports the patient id is necessary
   * The id should be existing in the patient table
   * It is matched with the help of query
   */
  public String checkPatientId(String id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String str = null;
    try {
      String checkQuery = "SELECT patient_id FROM patients WHERE patient_id = '" + id + "'";
      ResultSet rs = null;
      if (statement != null) {
        rs = statement.executeQuery(checkQuery);
      }
      if (rs != null) {
        while (rs.next()) {
          str = rs.getString("patient_id");
        }
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      databaseConnection.closeDBConnection();
    }
    return str;
  }
}
