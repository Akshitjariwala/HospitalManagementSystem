package BusinessLogicLayer.DoctorModule;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.Dao.DoctorLoginDAO;

import java.util.Scanner;

public class DoctorLogin {
  int temp = 0;

  public void login() {
    Doctor doctor = new Doctor();
    System.out.println("=============================Doctor Login=======================================");
    do {
      System.out.print("Enter Doctor Id : ");
      Scanner input = new Scanner(System.in);
      String doctorId = input.next();
      System.out.print("Enter Password : ");
      String password = input.next();
      temp = DoctorLoginDAO.checkDoctorLogin(doctorId, password);
      if (temp == 1) {
        doctor.setMedicalLicenseId(doctorId);
        DoctorHome doctorHome = new DoctorHome(doctorId);
        doctorHome.doctorHomePage();

      } else {
        System.out.println("Invalid details. Please login again");
      }
    } while (temp == 0);
  }
}
