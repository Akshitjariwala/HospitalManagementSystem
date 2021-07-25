package BusinessLogicLayer.AdminModule;

import PresentationLayer.AdminUI;

import java.util.Scanner;

public class CreateDoctor {

  public static void adminDoctorPage() {
    System.out.println("\n1. New Doctor Registration");
    System.out.println("2. Update Existing Doctor");
    System.out.println("3. Go to Admin Home Page");
    System.out.print("Enter Selection : ");
    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();

    // Action performed based on input choice
    if (choice == 1) {
      ManageDoctor.registration();
    } else if (choice == 2) {
      ManageDoctor.updateRegistration();
    } else if (choice == 3) {
      AdminUI al = new AdminUI();
      try {
        al.adminPage();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Invalid Input, Please choose either 1, 2 or 3");
    }
  }
}


