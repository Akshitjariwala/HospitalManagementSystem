package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.Dao.AddReportsDAO;
import DatabaseLayer.Dao.UpdateReportsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateReports {

    private static String str ="";

    public static void updateReports() throws SQLException, ClassNotFoundException {

        Scanner inputData = new Scanner(System.in);
        System.out.println("============================================================================");
        System.out.println("                      Update Reports");
        System.out.println("============================================================================");
        System.out.println("Enter the report id that has to be updated");
        int id = inputData.nextInt();
        Reports report = UpdateReportsDAO.getReportsDetails(id);
        int reportId = report.getReportId();

        System.out.println("===========The details of the report"+" "+ reportId+" "+"are==================");
        System.out.println("1.  Doctor Id :" + report.getDoctorId());
        System.out.println("2.  Patient Id :" + report.getPatientId());
        System.out.println("3.  Diagnosis Name :" + report.getDiagnosisName());
        System.out.println("4.  Date :"+ report.getDate());
        System.out.println("5.  Test Result :" + report.getTestResult() );
        System.out.println("6.  Test Type :" + report.getTestType() );
        System.out.println("7. Exit");
        System.out.println("Enter a number between 1 to 6 to update records. Enter 7 to exit");
        int input = inputData.nextInt();

        switch (input) {
            case 1:
                int doctorId;
                do {
                    System.out.println("Enter the doctor id :");
                    doctorId = inputData.nextInt();
                    int count = AddReportsDAO.checkDoctorId(doctorId);
                    if (count>0) {
                        str = "doc_id = " + "'" + doctorId + "'";
                    }else{
                        doctorId=0;
                        System.out.println("Please enter valid input:");
                    }
                }while (doctorId == 0);
                break;
            case 2:
                String strCheck;
                do {
                    System.out.println("Enter the Patient id :");
                    String patientId = inputData.next();
                    strCheck = AddReportsDAO.checkPatientId(patientId);
                    if (strCheck != null) {
                        str = "patient_id = " + "'" + patientId + "'";
                    }else{
                        strCheck = null;
                        System.out.println("Please enter valid input:");
                    }
                }while (strCheck == null);
                break;
            case 3:
                String diagnosisName;
                do {
                    System.out.println("Enter the Diagnosis Name :");
                    diagnosisName = inputData.next();
                    if (diagnosisName.matches("^[a-zA-Z0-9_ ]*$")) {
                        str = "diagnosis_name = " + "'" + diagnosisName + "'";
                    }else{
                        diagnosisName= null;
                        System.out.println("Please enter valid input:");
                    }
                }while (diagnosisName == null);

                break;
            case 4:
                String dateTest;
                do {
                    System.out.println("Enter the Date of Test :");
                    dateTest = inputData.next();
                    if (dateTest.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
                        str = "date = " + "'" + dateTest + "'";
                    }else{
                        dateTest = null;
                        System.out.println("Please enter valid input:");
                    }
                }while (dateTest == null);

                break;
            case 5:
                String testResult;
                do {
                    System.out.println("Enter the Test result :");
                    testResult = inputData.next();
                    if (testResult.matches("^[a-zA-Z0-9_ ]*$")) {
                        str = "test_result = " + "'" + testResult + "'";
                    }else{
                        testResult = null;
                        System.out.println("Please enter valid input:");
                    }
                }while (testResult == null);

                break;
            case 6:
                String testType;

                do {
                    System.out.println("Enter the Test Type :");
                    testType = inputData.next();
                    if (testType.matches("^[a-zA-Z0-9_ ]*$")) {
                        str = "test_type = " + "'" + testType + "'";
                    }else{
                        testType = null;
                        System.out.println("Please enter valid input:");
                    }
                }while (testType == null);

                break;
            case 7:
                break;

            default:
                System.out.println("Invalid Input, Please choose valid input ");

        }
        if(!str.isEmpty()){

            UpdateReportsDAO.updateReport(str, reportId );
        }

    }
}
