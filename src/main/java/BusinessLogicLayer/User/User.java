package BusinessLogicLayer.User;

import BusinessLogicLayer.DoctorModule.DoctorHome;
import DatabaseLayer.Dao.LoginDAO;
import PresentationLayer.AdminUI;
import PresentationLayer.PatientUI;

import java.util.Scanner;

public class User {
  private static final String ADMIN_USER_TYPE = "ADMIN";
  private static final String DOCTOR_USER_TYPE = "DOCTOR";
  private static final String PATIENT_USER_TYPE = "PATIENT";

  public void login() {
    System.out.println("============================= Enter Your Credentials =======================================");
    String userType;
    do {
      System.out.print("Enter User Id : ");
      Scanner input = new Scanner(System.in);
      String userName = input.next();
      System.out.print("Enter Password : ");
      String password = input.next();
      LoginDAO loginDAO = new LoginDAO();
      userType = loginDAO.checkUserExist(userName, password);
      if (userType != null) {
        switch (userType) {
          case ADMIN_USER_TYPE:
            AdminUI adminUI = new AdminUI();
            adminUI.adminPage();
            break;
          case DOCTOR_USER_TYPE:
            //DoctorHome doctorHome = new DoctorHome(doctor.getId());
            //doctorHome.doctorHomePage();
            break;
          case PATIENT_USER_TYPE:
            //PatientUI patientUI = new PatientUI();
            //patientUI.mainPatientUI(userID, patientName);
            break;
        }
      } else {
        System.out.println("Invalid details. Please login again");
      }
    } while (userType == null);
  }
}
