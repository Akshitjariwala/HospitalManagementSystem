package BusinessLogicLayer.User;

import BusinessLogicLayer.BeanClasses.Doctor;
import BusinessLogicLayer.DoctorModule.DoctorHome;
import DatabaseLayer.Dao.DoctorLoginDAO;

import java.util.Scanner;

public class DoctorUser extends User {

  @Override
  public void login() {
    int temp;
    Doctor doctor = new Doctor();
    System.out.println("============================= Doctor Login =======================================");
    do {
      System.out.print("Enter User Id : ");
      Scanner input = new Scanner(System.in);
      String doctorId = input.next();
      System.out.print("Enter Password : ");
      String password = input.next();
      DoctorLoginDAO doctorLoginDAO = new DoctorLoginDAO();
      temp = doctorLoginDAO.checkDoctorLogin(doctorId, password);
      if (temp == 1) {
        doctor.setMedicalLicenseId(doctorId);
        doctor = doctorLoginDAO.getDoctor(doctorId, password);
        DoctorHome doctorHome = new DoctorHome(doctor.getId());
        doctorHome.doctorHomePage();

      } else {
        System.out.println("Invalid details. Please login again");
      }
    } while (temp == 0);
  }
}
