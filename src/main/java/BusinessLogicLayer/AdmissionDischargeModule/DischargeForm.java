package BusinessLogicLayer.AdmissionDischargeModule;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class DischargeForm {

  static AdmissionDAO admissionDao = new AdmissionDAO();

  public void dischargeForm() throws SQLException {

    int flag = 0;
    String dischargeComment = null;
    LocalDate dischargeDate = java.time.LocalDate.now();
    Scanner userInput = new Scanner(System.in);
    System.out.print("\nEnter Patient ID  : ");
    String patientID = userInput.nextLine();
    boolean result = admissionDao.ifPatientExists(patientID);
    if(result){
      Admission admissionDetails = admissionDao.getAdmissionDetails(patientID);
      if(!Objects.isNull(admissionDetails))
      {
        do {
          System.out.println("\n=================================================");
          System.out.println("\t\t\t\tDischarge Form\t\t\t\t");
          System.out.println("=================================================");
          System.out.println("1. Patient ID      :\t" + admissionDetails.getPatientID());
          System.out.println("2. Admission Type  :\t" + admissionDao.getAdmissionType(admissionDetails.getAdmissionType()));
          System.out.println("3. Diagnose Code   :\t" + admissionDao.getDiseaseName(admissionDetails.getDiseaseID()));
          System.out.println("4. Physician       :\t" + admissionDao.getDoctorName(admissionDetails.getDoctorID()));
          System.out.println("5. Ward            :\t" + admissionDao.getWardCode(admissionDetails.getWardID()));
          System.out.println("6. Bed ID          :\t" + admissionDao.getBedCode(admissionDetails.getBedID()));
          System.out.println("7. Admission Date  :\t" + admissionDetails.getAdmissionDate());
          System.out.println("8. Discharge Date  :\t" + dischargeDate);
          System.out.print("9. Add Comment     :\t");
          Scanner userComment = new Scanner(System.in);
          dischargeComment = userComment.nextLine();
          admissionDetails.setDischargeComment(dischargeComment);
          admissionDetails.setDischargeDate(dischargeDate);
          System.out.printf("\n Select 0 to save the discharge form.");
          Scanner option = new Scanner(System.in);
          int response = option.nextInt();

          do {
            if(response == 0) {
              int res = admissionDao.dischargePatient(admissionDetails.getAdmissionID());
              if(res == 1){
                System.out.println("User Discharge Successful.");
              } else {
                System.out.println("User Discharge Failed.");
              }
            } else {
              System.out.println("Invalid Input Received! Please Enter Valid Input.");
            }
          } while(!(response ==0));

        }while(flag==0);
      } else {
        System.out.println("Entered Patient does not have any Admission/Discharge records. Please enter other Patient ID.");
      }
    } else {
      System.out.println("Entered Patient ID does not existing in the system. Please enter valid Patient ID.");
    }

  }
}
