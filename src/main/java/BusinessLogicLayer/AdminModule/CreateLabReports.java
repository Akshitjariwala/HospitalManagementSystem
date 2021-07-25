package BusinessLogicLayer.AdminModule;

import java.util.Scanner;

public class CreateLabReports {

  public static void reportHomePage() {
    System.out.println("1. Add New Reports");
    System.out.println("2. Update the Reports ");
    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();

    switch (choice) {
      case 1:
        ManageReports.addReports();
        break;
      case 2:
        ManageReports.updateReports();
        break;
    }
  }
}
