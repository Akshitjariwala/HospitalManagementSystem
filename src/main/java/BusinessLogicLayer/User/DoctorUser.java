/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles Doctor Login
 *
 * */
package BusinessLogicLayer.User;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.ActionDatabase.Doctor.Login.DoctorLoginDAO;
import PresentationLayer.DoctorUI;

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
        DoctorUI doctorHome = new DoctorUI(doctor.getId());
        doctorHome.doctorHomePage();

      } else {
        System.out.println("Invalid details. Please login again");
      }
    } while (temp == 0);
  }
}
