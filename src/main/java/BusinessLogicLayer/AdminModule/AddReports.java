package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.Dao.AddReportsDAO;
import DatabaseLayer.Dao.AddWardsDAO;

import java.util.Scanner;

public class AddReports {
    public static void addReports(){
        Reports report = new Reports();
        Scanner inputData = new Scanner(System.in);
        System.out.println("============================================================================");
        System.out.println("                      Add Reports");
        System.out.println("============================================================================");

        do {
            System.out.println("Enter the doctor id :");
            int doctorId = inputData.nextInt();
            int count = AddReportsDAO.checkDoctorId(doctorId);
            if (count>0) {
                report.setDoctorId(doctorId);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getDoctorId() == 0);

        do {
            System.out.println("Enter the Patient id :");
            String patientId = inputData.next();
            String str = AddReportsDAO.checkPatientId(patientId);
            if (str != null) {
                report.setPatientId(patientId);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getPatientId() == null);

        do {
            System.out.println("Enter the Diagnosis Name :");
            String diagnosisName = inputData.next();
            if (diagnosisName.matches("^[a-zA-Z0-9_ ]*$")) {
                report.setDiagnosisName(diagnosisName);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getDiagnosisName() == null);

        do {
            System.out.println("Enter the Date of Test :");
            String dateTest = inputData.next();
            if (dateTest.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")) {
                report.setDate(dateTest);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getDate() == null);

        do {
            System.out.println("Enter the Test result :");
            String testResult = inputData.next();
            if (testResult.matches("^[a-zA-Z0-9_ ]*$")) {
                report.setTestResult(testResult);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getTestResult() == null);

        do {
            System.out.println("Enter the Test Type :");
            String testType = inputData.next();
            if (testType.matches("^[a-zA-Z0-9_ ]*$")) {
                report.setTestType(testType);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (report.getTestType() == null);

        int status = AddReportsDAO.addReport(report);
        if(status ==1 ) {
            System.out.println("Report details added successfully");
        } else {
            System.out.println("ERROR while adding ward");
        }
    }
}
