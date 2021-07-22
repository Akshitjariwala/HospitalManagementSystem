package BusinessLogicLayer.AdmissionDischargeModule;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.Dao.AdmissionDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class DischargeForm {

  static AdmissionDAO admissionDao = new AdmissionDAO();

  public void dischargeForm() throws SQLException {

    int flag = 0;
    int flag1 = 0;
    int flag2 = 0;
    String dischargeComment = null;
    long timeToMil = System.currentTimeMillis();
    Date date = new Date(timeToMil);

    do {
      Scanner userInput = new Scanner(System.in);
      System.out.print("\nEnter Patient ID  : ");
      String patientID = userInput.nextLine();
      boolean result = admissionDao.ifPatientExists(patientID);
      if (result) {
        do{
        Admission admissionDetails = admissionDao.getAdmissionDetails(patientID);
        if (admissionDetails.getPatientID() != null) {
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
          System.out.println("8. Discharge Date  :\t" + date);
          System.out.print("9. Add Comment     :\t");
          Scanner userComment = new Scanner(System.in);
          dischargeComment = userComment.nextLine();
          admissionDetails.setDischargeComment(dischargeComment);
          admissionDetails.setDischargeDate(date);

          do {
            System.out.println("\n\nSelect 0 to save the discharge form or Select 1 to edit Discharge Comment.");
            Scanner option = new Scanner(System.in);
            int response = option.nextInt();

            switch (response) {
              case 0:
                boolean res = admissionDao.dischargePatient(admissionDetails);
                if (res) {
                  System.out.println("\nUser Successfully Discharged.");
                  flag1 = 1;
                  flag = 1;
                  flag2 = 1;
                } else {
                  System.out.println("\nUser Discharge Failed.");
                }
                break;
              case 1:
                flag = 0;
                flag1 = 1;
            }
          } while (flag1 == 0);

        } else {
          System.out.println("\nEntered Patient does not have any Admission/Discharge records. Please enter other Patient ID.");
        }
      }while(flag2==0);
      } else {
        System.out.println("\nEntered Patient ID does not existing in the system. Please enter valid Patient ID.");
      }
    }while(flag == 0);
  }
}
