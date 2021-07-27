package PresentationLayer;

import BusinessLogicLayer.User.AdminUser;
import BusinessLogicLayer.User.DoctorUser;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    mainMethod();
  }

  public static void mainMethod() {
    System.out.println("============================================================");
    System.out.println("\t\tWelcome to our Hospital Management System\t\t");
    System.out.println("============================================================");
    System.out.println("Choose one of the following login option...\n");
    System.out.println("1. Doctor");
    System.out.println("2. Patient");
    System.out.println("3. Admin");
    System.out.println("4. Exit");

    int flag = 0;
    do {
      System.out.println("Select number between 1-4 to perform appropriate action.\n");
      System.out.print("Enter Selection : ");
      Scanner userInput = new Scanner(System.in);
      int choice = userInput.nextInt();
      if (choice > 0 && choice <= 4) {
        switch (choice) {
          case 1:
            DoctorUser doctor = new DoctorUser();
            doctor.login();
            flag = 1;
            break;
          case 2:
            PatientUI patientUI = new PatientUI();
            patientUI.loginOrRegistrationUI();
            flag = 1;
            break;
          case 3:
            AdminUser adminUser = new AdminUser();
            adminUser.login();
            flag = 1;
            break;
          case 4:
            System.exit(1);
            flag = 1;
          case 5:
        }
      } else {
        System.out.printf("%n");
        System.err.println("Invalid Input Received! Please Enter Valid Selection.");
        System.out.printf("%n");
      }
    } while (flag == 0);
  }
}
