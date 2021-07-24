/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Doctor;

import java.sql.SQLException;
import java.util.Scanner;

import DatabaseLayer.Dao.RegisterDoctorDAO;
import PresentationLayer.AdminLogin;

public class RegisterDoctor {

  /* Doctor Details are taken as input
   * The details are stored into database
   */
  public static void registration() {
    Doctor doct = new Doctor();
    Scanner inputData = new Scanner(System.in);
    System.out.println("============================================================================");
    System.out.println("                      Doctor Registration");
    System.out.println("============================================================================");
    System.out.println("Please enter the below details");
    System.out.println("Note: * denotes mandatory fields");

    do {
      System.out.println("Medical License Id* :");
      String medicalLicenseId = inputData.nextLine();
      if (medicalLicenseId.matches("^[a-zA-Z0-9_.-]*$")) {
        doct.setMedicalLicenseId(medicalLicenseId);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getMedicalLicenseId() == null);

    do {
      System.out.println("Last Name* :");
      String lastName = inputData.nextLine();
      if (lastName.matches("[A-Za-z]*")) {
        doct.setLastName(lastName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getLastName() == null);

    do {
      System.out.println("Middle Name* :");
      String middleName = inputData.nextLine();
      if (middleName.matches("[A-Za-z]*")) {
        doct.setMiddleName(middleName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getMiddleName() == null);

    do {
      System.out.println("First Name* :");
      String firstName = inputData.nextLine();
      if (firstName.matches("[A-Za-z]*")) {
        doct.setFirstName(firstName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getFirstName() == null);

    do {
      System.out.println("Email* :");
      String emailId = inputData.nextLine();
      if (emailId.matches("^(.+)@(.+)$")) {
        doct.setEmailId(emailId);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getEmailId() == null);

    do {
      System.out.println("Phone number* :");
      String phoneNumber = inputData.nextLine();
      if (phoneNumber.matches("\\d{10}")) {
        doct.setPhoneNumber(phoneNumber);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getPhoneNumber() == null);

    do {
      System.out.println("Specialization*:");
      String specialization = inputData.nextLine();
      if (specialization.matches("[A-Za-z]*")) {
        doct.setSpecialization(specialization);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getSpecialization() == null);

    do {
      System.out.println("Department* :");
      String department = inputData.nextLine();

      if (department.matches("[A-Za-z]*")) {
        doct.setDepartment(department);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getDepartment() == null);


    do {
      System.out.println("Experience* :");
      String experience = inputData.nextLine();
      if (experience.matches("^[0-9]*$")) {
        doct.setExperience(experience);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getExperience() == null);

    do {
      System.out.println("Password* :");
      String password = inputData.nextLine();

      if (password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" +
              "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$")) {
        doct.setPassword(password);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getPassword() == null);


    System.out.println("Address* :");
    String address = inputData.nextLine();
    doct.setAddress(address);

    do {
      System.out.println("City* : ");
      String city = inputData.nextLine();

      if (city.matches("[A-Za-z]*")) {
        doct.setCity(city);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getCity() == null);

    do {
      System.out.println("State* :");
      String state = inputData.nextLine();
      if (state.matches("[A-Za-z]*")) {
        doct.setState(state);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getState() == null);
    RegisterDoctorDAO registerDoctorDAO = new RegisterDoctorDAO();
    int status = registerDoctorDAO.addDoctor(doct);
    if (status == 1) {
      System.out.println("Doctor details added successfully");
    } else {
      System.out.println("ERROR while adding details");
    }
    CreateDoctor.adminDoctorPage();
  }



}