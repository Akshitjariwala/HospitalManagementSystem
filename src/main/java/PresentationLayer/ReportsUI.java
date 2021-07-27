/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles reports
 *
 * */
package PresentationLayer;

import BusinessLogicLayer.AdminModule.ManageReports;

import java.util.Scanner;

public class ReportsUI {

  private final ManageReports manageReports = new ManageReports();

  public void reportHomePage() {
    System.out.println("1. Add New Reports");
    System.out.println("2. Update the Reports ");
    Scanner input = new Scanner(System.in);
    int choice = input.nextInt();

    switch (choice) {
      case 1:
        manageReports.addReports();
        break;
      case 2:
        manageReports.updateReports();
        break;
    }
  }
}
