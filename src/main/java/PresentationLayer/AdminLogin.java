package PresentationLayer;

import BusinessLogicLayer.AdminModule.CreateLabReports;
import BusinessLogicLayer.AdminModule.ManageAppointments;
import BusinessLogicLayer.AdminModule.ManageWards;
import BusinessLogicLayer.AdminModule.RegisterDoctor;
import BusinessLogicLayer.AdmissionDischargeModule.NewAdmissionFormCreation;
import java.util.Scanner;

public class AdminLogin {

  public void AdminLoginPage() throws Exception {

    int choiceFlag = 0;

    do {
      System.out.println("\n=================================================");
      System.out.println("\t\t\t\tAdmin Login Page\t\t\t");
      System.out.println("=================================================");
      System.out.printf("%n");
      System.out.print("1. Provide Login ID : ");
      Scanner loginInput = new Scanner(System.in);
      String loginID = loginInput.nextLine();
      System.out.print("2. Provide Password : ");
      Scanner loginPassword = new Scanner(System.in);
      String password = loginPassword.nextLine();

      if (loginID != null && password != null) {
        if(loginID.equals("admin") & password.equals("admin")){ // Provide Valid Admin Login Password.
          AdminPage();
        } else {
          System.out.println("\nUser Login ID and Password Doesnt Match. Please Provide Valid Login ID and Password.\n");
        }
      } else {
        System.out.println("\nInvalid Input Received! Please Enter Valid Selection.\n");
      }
    } while (choiceFlag == 0);
  }

  public void AdminPage() throws Exception {

    int choiceFlag=0;
    int exitFlag=0;

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
      System.out.printf("\nSelect number between 1-6 to perform appropriate action.\n\n");

      do {
        System.out.print("Enter Selection : ");
        Scanner userInput = new Scanner(System.in);
        int choice = userInput.nextInt();
        if (choice >= 1 && choice <= 6) {
          switch (choice) {
            case 1: RegisterDoctor registration = new RegisterDoctor();
              registration.registerDoctor();
              exitFlag=1;break;
            case 2: NewAdmissionFormCreation admissionModule = new NewAdmissionFormCreation();
              admissionModule.admissionHomePage();
              exitFlag=1;break;
            case 3: ManageWards manageWards = new ManageWards();
              manageWards.manageWards();
              exitFlag=1;break;
            case 4: CreateLabReports labReports = new CreateLabReports();
              labReports.reportHomePage();
              exitFlag=1;break;
            case 5:
              ManageAppointments manageAppointments = new ManageAppointments();
              manageAppointments.manageAppointmentHome();
              exitFlag = 1;
              break;
            case 6: Main main = new Main();
                    main.mainMethod();
                    break;
          }
          choiceFlag = 1;
        } else {
          System.out.println("\nInvalid Input Received! Please Enter Valid Selection.\n");
        }
      } while (choiceFlag == 0);
    }while(exitFlag==0);
  }
}
