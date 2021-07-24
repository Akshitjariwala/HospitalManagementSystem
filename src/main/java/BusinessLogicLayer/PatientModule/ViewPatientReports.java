/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles allows patient to check
 * their own lab reports, along with the result once he/she is
 * successfully logged in.
 * The database access is done using common DatabaseConnection class
 *
 * */
package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.PatientModule.PatientInterfaces.ViewLabReportsInterface;
import DatabaseLayer.Dao.ViewPatientReportsDAO;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import PresentationLayer.PatientUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class ViewPatientReports implements ViewLabReportsInterface {

  //private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
 // private static Connection connection = databaseConnection.openDBConnection();
  private Statement statement = null;
  ResultSet resultSet=null;
  private ViewPatientReportsDAO viewPatientReportsDAO=new ViewPatientReportsDAO();


  public void viewLabReports(String patientID,String patientName) {

    System.out.println("\n===========================\n\tYOUR LAB REPORTS\n===========================");
    System.out.println("Fetching Lab Reports.....\n");
    try {
      TimeUnit.SECONDS.sleep(5);
      System.out.println("|\tNo.\t|\tPatient_id\t|\tDiagnosis Name\t|\tReferred By\t\t|\tDate\t|\tTest Type\t|\tResult\t|");
      System.out.println("--------------------------------------------------------------------------------------------------------------------");
//      String queryToFetchReports = "SELECT rep_id,diagnosis_name,CONCAT('Dr.',dr.first_name,' ',dr.last_name) as Referred_By,date,test_type,test_result \n" +
//              "FROM lab_reports lr join doctors dr on dr.id=lr.doc_id \n" +
//              "WHERE lr.patient_id='" + patientID + "';";
//      statement = connection.createStatement();
//      resultSet = statement.executeQuery(queryToFetchReports);
      resultSet= viewPatientReportsDAO.fetchLabReports(patientID);
      int index = 0;

      if (resultSet.getRow()!=0){
        while (resultSet.next()) {
          index++;
          int reportID = resultSet.getInt(1);
          String diagnosisType = resultSet.getString(2);
          String doctorName = resultSet.getString(3);
          String dateOfReport = resultSet.getString(4);
          String testType = resultSet.getString(5);
          String result = resultSet.getString(6);
          System.out.println("|\t" + index + "\t\tReport " + reportID + "\t\t\t" + diagnosisType + "\t\t" + doctorName + "\t\t" + dateOfReport + "\t\t" + testType + "\t\t" + result);
        }
      }else {
        System.out.println("\t--------------- NO NEW REPORTS AVAILABLE ---------------");
      }

      //Redirect to previous Menu
      PatientUI patientUI=new PatientUI();
      patientUI.mainPatientUI(patientID,patientName);
    } catch (InterruptedException e) {
      System.err.print("INTERRUPTED");
    } catch (SQLException e) {
      System.err.print("SQL ERROR");
    }
  }
}
