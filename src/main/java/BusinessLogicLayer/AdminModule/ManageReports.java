/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles Reports
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.Reports.IManageReportsDAO;
import PresentationLayer.AdminUI;

import java.util.Scanner;

public class ManageReports extends AdminAbstractAction implements IManageReports {

  private IManageReportsDAO iManageReportsDAO;

  private static final String ACTION_TITLE = "Manage Reports";

  public ManageReports() {
    iManageReportsDAO = iAdminActionDatabase.reportsDAO();
  }

  private static String str = "";

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  /* New Reports are added
   * The report details are taken as input
   * The details are stored into database
   */
  @Override
  public void addReports() {
    Reports report = new Reports();
    Scanner inputData = new Scanner(System.in);
    System.out.println("============================================================================");
    System.out.println("                      Add Reports");
    System.out.println("============================================================================");

    do {
      System.out.println("Enter the Doctor Id :");
      String doctorId = inputData.next();
      int count = iManageReportsDAO.checkDoctorId(doctorId);
      if (count > 0) {
        report.setDoctorId(doctorId);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getDoctorId() == null);

    do {
      System.out.println("Enter the Patient id :");
      String patientId = inputData.next();
      String str = iManageReportsDAO.checkPatientId(patientId);
      if (str != null) {
        report.setPatientId(patientId);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getPatientId() == null);

    do {
      System.out.println("Enter the Diagnosis Name :");
      String diagnosisName = inputData.next();
      if (diagnosisName.matches("^[a-zA-Z0-9_ ]*$")) {
        report.setDiagnosisName(diagnosisName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getDiagnosisName() == null);

    do {
      System.out.println("Enter the Date of Test :");
      String dateTest = inputData.next();
      if (dateTest.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
        report.setDate(dateTest);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getDate() == null);

    do {
      System.out.println("Enter the Test result :");
      String testResult = inputData.next();
      if (testResult.matches("^[a-zA-Z0-9_ ]*$")) {
        report.setTestResult(testResult);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getTestResult() == null);

    do {
      System.out.println("Enter the Test Type :");
      String testType = inputData.next();
      if (testType.matches("^[a-zA-Z0-9_ ]*$")) {
        report.setTestType(testType);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (report.getTestType() == null);

    int status = iManageReportsDAO.addReport(report);
    if (status == 1) {
      System.out.println("Report details added successfully");
    } else {
      System.out.println("ERROR while adding ward");
    }
    AdminUI adminLogin = new AdminUI();
    try {
      adminLogin.adminPage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* The details of the reports can be updated
   * An input for the id is taken for which the details are needed to be updated
   * The details are fetched from database and are displayed
   * The user will have privilege to edit the details and the details are updated in database
   */
  @Override
  public void updateReports() {

    Scanner inputData = new Scanner(System.in);
    System.out.println("============================================================================");
    System.out.println("                      Update Reports");
    System.out.println("============================================================================");
    System.out.println("Enter the report id that has to be updated");
    int id = inputData.nextInt();

    Reports report = iManageReportsDAO.getReportsDetails(id);
    int reportId = report.getReportId();

    System.out.println("===========The details of the report" + " " + reportId + " " + "are==================");
    System.out.println("1. Doctor Id :" + report.getDoctorId());
    System.out.println("2. Patient Id :" + report.getPatientId());
    System.out.println("3. Diagnosis Name :" + report.getDiagnosisName());
    System.out.println("4. Date :" + report.getDate());
    System.out.println("5. Test Result :" + report.getTestResult());
    System.out.println("6. Test Type :" + report.getTestType());
    System.out.println("7. Exit");
    System.out.println("Enter a number between 1 to 6 to update records. Enter 7 to exit");
    int input = inputData.nextInt();

    switch (input) {
      case 1:
        String doctorId;
        do {
          System.out.println("Enter the doctor id :");
          doctorId = inputData.next();
          int count = iManageReportsDAO.checkDoctorId(doctorId);
          if (count > 0) {
            str = "doc_id = " + "'" + doctorId + "'";
          } else {
            doctorId = null;
            System.out.println("Please enter valid input:");
          }
        } while (doctorId == null);
        break;
      case 2:
        String strCheck;
        do {
          System.out.println("Enter the Patient id :");
          String patientId = inputData.next();
          strCheck = iManageReportsDAO.checkPatientId(patientId);
          if (strCheck != null) {
            str = "patient_id = " + "'" + patientId + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (strCheck == null);
        break;
      case 3:
        String diagnosisName;
        do {
          System.out.println("Enter the Diagnosis Name :");
          diagnosisName = inputData.next();
          if (diagnosisName.matches("^[a-zA-Z0-9_ ]*$")) {
            str = "diagnosis_name = " + "'" + diagnosisName + "'";
          } else {
            diagnosisName = null;
            System.out.println("Please enter valid input:");
          }
        } while (diagnosisName == null);

        break;
      case 4:
        String dateTest;
        do {
          System.out.println("Enter the Date of Test :");
          dateTest = inputData.next();
          if (dateTest.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
            str = "date = " + "'" + dateTest + "'";
          } else {
            dateTest = null;
            System.out.println("Please enter valid input:");
          }
        } while (dateTest == null);

        break;
      case 5:
        String testResult;
        do {
          System.out.println("Enter the Test result :");
          testResult = inputData.next();
          if (testResult.matches("^[a-zA-Z0-9_ ]*$")) {
            str = "test_result = " + "'" + testResult + "'";
          } else {
            testResult = null;
            System.out.println("Please enter valid input:");
          }
        } while (testResult == null);

        break;
      case 6:
        String testType;

        do {
          System.out.println("Enter the Test Type :");
          testType = inputData.next();
          if (testType.matches("^[a-zA-Z0-9_ ]*$")) {
            str = "test_type = " + "'" + testType + "'";
          } else {
            testType = null;
            System.out.println("Please enter valid input:");
          }
        } while (testType == null);

        break;
      case 7:
        break;

      default:
        System.out.println("Invalid Input, Please choose valid input ");

    }
    if (!str.isEmpty()) {
      iManageReportsDAO.updateReport(str, reportId);
      System.out.println("Report Updated Successfully.");
      AdminUI adminLogin = new AdminUI();
      try {
        adminLogin.adminPage();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
