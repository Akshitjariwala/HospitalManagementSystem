package BusinessLogicLayer.DoctorModule;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.Dao.ViewReportsDao;

public class ViewReports {

  private int docId;
  private ViewReportsDao vrdao;

  public ViewReports(int docId) {
    this.docId = docId;
    vrdao = new ViewReportsDao();
  }

  public boolean viewAllReports() {
    List<Reports> reports = vrdao.getAllReports(this.docId);
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

  public boolean viewPatientReports(String patientId) {
    List<Reports> reports = vrdao.getPatientReports(this.docId, patientId);
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
