/*
 * CSCI 5308 Group Project
 * @author: Akshit Jariwala
 * @description: This Module handles Login UI for system Admin.
 */

package PresentationLayer;

import BusinessLogicLayer.AdminModule.ManageAppointments;
import BusinessLogicLayer.AdminModule.ManageWards;

import java.util.Scanner;

public class AdminUI {

  public void adminPage() {
    int choiceFlag = 0;
    int exitFlag = 0;
    ManageAppointments manageAppointments = new ManageAppointments();
    ManageWards manageWards = new ManageWards();
    do {
      System.out.println("\n=================================================");
      System.out.println("\t\t\t\tAdmin Home Page\t\t\t\t");
      System.out.println("=================================================");
      System.out.printf("%n");
      System.out.println("1. Doctor Management");
      System.out.println("2. Admission Discharge");
      System.out.println("3. " + manageWards.getActionTitle());
      System.out.println("4. Manage Reports");
      System.out.println("5. " + manageAppointments.getActionTitle());
      System.out.println("6. Logout");
      System.out.print("Select number between 1-6 to perform appropriate action.\n");

      do {
        System.out.print("Enter Selection : ");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice >= 1 && choice <= 6) {
          switch (choice) {
            case 1:
              DoctorManagementUI doctorManagementUI = new DoctorManagementUI();
              doctorManagementUI.adminDoctorPage();
              exitFlag = 1;
              break;
            case 2:
              AdmissionFormUI admissionModule = new AdmissionFormUI();
              admissionModule.admissionHomePage();
              exitFlag = 1;
              break;
            case 3:
              WardUI wardUI = new WardUI();
              wardUI.wardManageHomePage();
              exitFlag = 1;
              break;
            case 4:
              ReportsUI reportsUI = new ReportsUI();
              reportsUI.reportHomePage();
              exitFlag = 1;
              break;
            case 5:
              manageAppointments.manageAppointmentHome();
              exitFlag = 1;
              break;
            case 6:
              Main.mainMethod();
              break;
          }
          choiceFlag = 1;
        } else {
          System.out.println("\nInvalid Input Received! Please Enter Valid Selection.\n");
        }
      } while (choiceFlag == 0);
    } while (exitFlag == 0);
  }
}
