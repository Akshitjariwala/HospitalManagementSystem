/*
 * CSCI 5308 Group Project
 * @author: Vishal Rakesh Jaiswal
 * @description: This program allows a doctor to view either reports of all the patients
 * under the supervision of the doctor or reports of a specific patient.
 * The database access is done using common DatabaseConnection class
 *
 * */
package BusinessLogicLayer.DoctorModule;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.ActionDatabase.Doctor.DoctorAbstractAction;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.IViewReportsDao;

public class ViewReports extends DoctorAbstractAction implements IViewReports {

  private int docId;
  private IViewReportsDao iViewReportsDao;
  private static final String ACTION_TITLE = "View Reports";

  public ViewReports(int docId) {
    this.docId = docId;
    iViewReportsDao = iDoctorActionDatabase.viewReportsDAO();
  }
  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }
  @Override
  public boolean viewAllReports() {
    List<Reports> reports = iViewReportsDao.getAllReports(this.docId);
    if (reports.size() > 0) {
      System.out.println("\n================================================================");
      System.out.println("\t\t\t\tAll Reports under your supervision\t\t\t\t");
      System.out.println("================================================================");
      System.out.printf("%n");
      System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-20s %-50s %-10s %-10s %-30s%n", "Report Id", " | ", "PatientID", " | ", "Diagnosis Name", " | ", "Report Date", " | ", "Result", " | ", "Report Type");
      for (Reports report : reports) {
        System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-20s %-50s %-10s %-10s %-30s%n", report.getReportId(), " | ", report.getPatientId(), " | ", report.getDiagnosisName(), " | ", report.getDate(), " | ", report.getTestResult(), " | ", report.getTestType());
      }
      System.out.printf("%n");
      return true;
    } else {
      System.out.println("\n==================================================");
      System.out.println("\t\tCurrently no reports for patients under your supervision\t\t");
      System.out.println("==================================================");
      return false;
    }
  }
  @Override
  public boolean viewPatientReports(String patientId) {
    List<Reports> reports = iViewReportsDao.getPatientReports(this.docId, patientId);
    if (reports.size() > 0) {
      System.out.println("\n================================================================");
      System.out.println("\t\t\t\tAll Reports of Patient\t\t\t\t");
      System.out.println("================================================================");
      System.out.printf("%n");
      System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-20s %-50s %-10s %-10s %-30s%n", "Report Id", " | ", "PatientID", " | ", "Diagnosis Name", " | ", "Report Date", " | ", "Result", " | ", "Report Type");
      for (Reports report : reports) {
        System.out.printf("%-10s %-10s %-10s %-20s %-20s %-10s %-20s %-50s %-10s %-10s %-30s%n", report.getReportId(), " | ", report.getPatientId(), " | ", report.getDiagnosisName(), " | ", report.getDate(), " | ", report.getTestResult(), " | ", report.getTestType());
      }
      System.out.printf("%n");
      return true;
    } else {
      System.out.println("\n==================================================");
      System.out.println("\t\tCurrently no reports for patients under your supervision\t\t");
      System.out.println("==================================================");
      return false;
    }
  }
}
