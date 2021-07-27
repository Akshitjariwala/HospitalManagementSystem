package PresentationLayer;

import BusinessLogicLayer.AdminModule.ManageWards;

import java.util.Scanner;

public class WardUI {

  private final ManageWards manageWards = new ManageWards();

  public void wardManageHomePage() {
    int flag = 0;
    do {
      System.out.println("=================================================");
      System.out.println("\t\t\t\tWard Management\t\t\t\t");
      System.out.println("=================================================");
      System.out.printf("%n");
      System.out.println("1. Add new Wards");
      System.out.println("2. Update existing Wards");
      System.out.println("3. Show bed Availability");
      System.out.println("4. Patient-wise bed details");
      System.out.println("5. Go to Admin Home Page");
      System.out.println("6. Exit");
      System.out.printf("%n");
      System.out.print("Select number between 1-6 to perform appropriate action.");
      System.out.printf("%n");
      System.out.print("Enter Selection : ");

      Scanner userInput = new Scanner(System.in);
      int choice = userInput.nextInt();
      if (choice > 0 && choice <= 5) {
        switch (choice) {
          case 1:
            manageWards.addWards();
            flag = 1;
            break;
          case 2:
            manageWards.updateWards();
            flag = 1;
            break;
          case 3:
            manageWards.checkBedAvailability();
            flag = 1;
            break;
          case 4:
            manageWards.checkPatientWiseBedDetails();
            flag = 1;
            break;
          case 5:
            AdminUI adminLogin = new AdminUI();
            try {
              adminLogin.adminPage();
            } catch (Exception e) {
              e.printStackTrace();
            }
          case 6:
            System.exit(1);// exit()
            flag = 1;
        }
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
        System.out.printf("%n");
      }
    } while (flag == 0);
  }
}
