/*
 * CSCI 5308 Group Project
 * @author: Akshit Jariwala
 * @description: This Module handles Discharge functionality
 * It handles the discharge of the Patient and release of resources.
 */

package BusinessLogicLayer.AdmissionDischargeModule;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class DischargeForm extends AdminAbstractAction implements IDischargeForm {

  public static IAdmissionDetailsDAO getAdmissionDetailsDao;
  public static IAdmissionTypeDAO admissionTypeDAO;
  public static IBedAdmissionDAO bedAdmissionDAO;
  public static IDiseaseDAO diseaseDAO;
  public static IDoctorDAO doctorDAO;
  public static IPatientDAO patientDAO;
  public static IWardAdmissionDAO wardDAO;
  public static IDischargeFormDAO dischargeDAO;
  private static final String ACTION_TITLE = "Discharge Form";

  public DischargeForm(){
    getAdmissionDetailsDao = iAdminActionDatabase.admissionDetailsDAO();
    admissionTypeDAO = iAdminActionDatabase.admissionTypeDAO();
    bedAdmissionDAO = iAdminActionDatabase.bedAdmissionDAO();
    diseaseDAO = iAdminActionDatabase.diseaseDAO();
    doctorDAO = iAdminActionDatabase.doctorDAO();
    patientDAO = iAdminActionDatabase.patientDAO();
    wardDAO = iAdminActionDatabase.wardAdmissionDAO();
    dischargeDAO = iAdminActionDatabase.dischargeDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  @Override
  public void dischargeForm() {

    int flag = 0;
    int flag1 = 0;
    int flag2 = 0;
    String dischargeComment;
    long timeToMil = System.currentTimeMillis();
    Date date = new Date(timeToMil);
    try {
      do {
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nEnter Patient ID  : ");
        String patientID = userInput.nextLine();
        boolean result = patientDAO.ifPatientExists(patientID);
        if (result) {
          do {
            Admission admissionDetails = getAdmissionDetailsDao.getAdmissionDetails(patientID);
            if (admissionDetails.getPatientID() != null) {
              System.out.println("\n=================================================");
              System.out.println("\t\t\t\tDischarge Form\t\t\t\t");
              System.out.println("=================================================");
              System.out.println("1. Patient ID      :\t" + admissionDetails.getPatientID());
              System.out.println("2. Admission Type  :\t" + admissionTypeDAO.getAdmissionType(admissionDetails.getAdmissionType()));
              System.out.println("3. Diagnose Code   :\t" + diseaseDAO.getDiseaseName(admissionDetails.getDiseaseID()));
              System.out.println("4. Physician       :\t" + doctorDAO.getDoctorName(admissionDetails.getDoctorID()));
              System.out.println("5. Ward            :\t" + wardDAO.getWardCode(admissionDetails.getWardID()));
              System.out.println("6. Bed ID          :\t" + bedAdmissionDAO.getBedCode(admissionDetails.getBedID()));
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
                    boolean res;
                    res = dischargeDAO.dischargePatient(admissionDetails);
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
          } while (flag2 == 0);
        } else {
          System.out.println("\nEntered Patient ID does not existing in the system. Please enter valid Patient ID.");
        }
      } while (flag == 0);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
