package PresentationLayer;

import BusinessLogicLayer.AdminModule.CreateLabReports;
import BusinessLogicLayer.AdminModule.ManageAppointments;
import BusinessLogicLayer.AdminModule.ManageWards;
import BusinessLogicLayer.AdminModule.RegisterDoctor;
import BusinessLogicLayer.AdmissionDischargeModule.NewAdmissionFormCreation;
import BusinessLogicLayer.WardModule.WardHome;

import java.util.Scanner;

public class AdminLogin {

  public void AdminLoginPage() throws Exception {

    int choiceFlag = 0;

    System.out.println("\n=================================================");
    System.out.println("\t\t\t\tAdmin Login Page\t\t\t");
    System.out.println("=================================================");
    System.out.printf("%n");
    System.out.println("1. Register Admin");
    System.out.println("2. Login Admin");
    System.out.println("\n\nSelect number between 1-2 to perform appropriate action.\n\nEnter Selection : ");

    do {
      Scanner userChoice = new Scanner(System.in);
      int choice = userChoice.nextInt();

      if (choice >= 1 && choice <= 2) {
        switch (choice) {
          case 1:
            AdminRegistration();
            choiceFlag = 1;
            break;
          case 2:
            AdminLogin();
            choiceFlag = 1;
            break;
        }
      } else {
        System.out.println("\nInvalid Input Received! Please Enter Valid Selection.");
      }
    } while (choiceFlag == 0);
  }


  public void AdminRegistration() {
    System.out.println("Yet To Be Developed.");
  }

  public void AdminLogin() throws Exception {
    System.out.println("Yet To Be Developed.");
    AdminPage();
  }

  public void AdminPage() throws Exception {

    int choiceFlag = 0;
    int exitFlag = 0;

    do {
      System.out.println("\n=================================================");
      System.out.println("\t\t\t\tAdmin Page\t\t\t\t");
      System.out.println("=================================================");
      System.out.printf("%n");
      System.out.println("1. Doctor Registration");
      System.out.println("2. Admission Discharge");
      System.out.println("3. Manage Wards");
      System.out.println("4. Manage Reports");
      System.out.println("5. Manage Appointments");
      System.out.println("6. Exit");
      System.out.printf("\nSelect number between 1-5 to perform appropriate action.\n\n");

      do {
        System.out.println("Enter Selection : ");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice >= 1 && choice <= 6) {
          switch (choice) {
            case 1:
              RegisterDoctor registration = new RegisterDoctor();
              registration.registerDoctor();
              exitFlag = 1;
              break;
            case 2:
              NewAdmissionFormCreation admissionModule = new NewAdmissionFormCreation();
              admissionModule.admissionHomePage();
              exitFlag = 1;
              break;
            case 3:
              WardHome wardHome = new WardHome();
              wardHome.wardManageHomePage();
              exitFlag = 1;
              break;
            case 4:
              CreateLabReports labReports = new CreateLabReports();
              labReports.reportHomePage();
              exitFlag = 1;
              break;
            case 5:
              ManageAppointments manageAppointments = new ManageAppointments();
              manageAppointments.manageAppointmentHome();
              exitFlag = 1;
              break;
            case 6:
              exitFlag = 1;
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
