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

import BusinessLogicLayer.PatientModule.PatientInterfaces.IViewLabReports;
import DatabaseLayer.ActionDatabase.Patient.PatientAbstractAction;
import DatabaseLayer.ActionDatabase.Patient.ViewReports.IViewPatientReportsDAO;
import PresentationLayer.PatientUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class ViewPatientReports extends PatientAbstractAction implements IViewLabReports {

  private Statement statement = null;
  private IViewPatientReportsDAO iViewPatientReportsDAO;
  private static final String ACTION_TITLE = "View Patient Reports";

  public ViewPatientReports() {
    iViewPatientReportsDAO = iPatientActionDatabase.viewReportsDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  public void viewLabReports(String patientID, String patientName) {

    ResultSet resultSet = null;
    System.out.println("\n===========================\n\tYOUR LAB REPORTS\n===========================");
    System.out.println("Fetching Lab Reports.....\n");
    try {
      TimeUnit.SECONDS.sleep(5);
      System.out.println("|\tNo.\t|\tPatient_id\t|\tDiagnosis Name\t|\tReferred By\t\t|\tDate\t|\tTest Type\t|\tResult\t|");
      System.out.println("--------------------------------------------------------------------------------------------------------------------");
      resultSet = iViewPatientReportsDAO.fetchLabReports(patientID);
      int index = 0;

      if (resultSet.next()) {
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
      } else {
        System.out.println("\t--------------- NO NEW REPORTS AVAILABLE ---------------");
      }

      //Redirect to previous Menu
      PatientUI patientUI = new PatientUI();
      patientUI.mainPatientUI(patientID, patientName);
    } catch (InterruptedException e) {
      System.err.print("INTERRUPTED");
    } catch (SQLException e) {
      System.err.print("SQL ERROR");
    }
  }
}
