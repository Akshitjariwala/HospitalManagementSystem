/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles allows patient to
 * select different feature of the system based on his/her type
 * i.e. existing or new.
 *
 */
package PresentationLayer;

import BusinessLogicLayer.PatientModule.BookAppointments;
import BusinessLogicLayer.PatientModule.PatientRegistration;
import BusinessLogicLayer.PatientModule.ViewPatientReports;
import BusinessLogicLayer.User.PatientUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatientUI {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public void mainPatientUI(String patientID, String patientName) {

    BookAppointments appointments = new BookAppointments();
    ViewPatientReports viewPatientReports = new ViewPatientReports();

    int optionSelected = 0;

    System.out.println("\nWelcome ******* " + patientName + " *******\n");

    System.out.println("1. Book Appointment");
    System.out.println("2. View Lab Reports");
    System.out.println("3. Logout");
    try {
      boolean optionFlag = false;
      do {
        if ((optionSelected != 999999) && optionFlag)
          System.err.println("*** Please choose either 1 or 2 ***\n");

        System.out.print("Enter Selection : ");
        String input = reader.readLine();
        if (input != null && !input.isEmpty()) {
          optionSelected = Integer.parseInt(input);
          optionFlag = true;
        }
      } while (!(optionSelected > 0 && optionSelected < 4));

      switch (optionSelected) {
        case 1:
          appointments.appointmentBookingPortalofPatient(patientID);
          break;

        case 2:
          viewPatientReports.viewLabReports(patientID, patientName);
          break;

        case 3:
          try {
            Main.mainMethod();
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;

        default:
          System.err.println("Some error occured");
          break;
      }
    } catch (IOException e) {
      System.err.println("I/O ERROR");
    }
  }

  public void loginOrRegistrationUI() {
    PatientRegistration newPatient = new PatientRegistration();

    int optionSelected = 0;
    System.out.println("\n1. Existing Patient");
    System.out.println("2. New Patient");
    try {
      boolean optionFlag = false;
      do {
        if (optionSelected != 999999 && optionFlag)
          System.err.println("\n*** Please choose either 1 or 2***\n");

        System.out.print("Enter Selection : ");
        optionSelected = Integer.parseInt(reader.readLine());
        optionFlag = true;
      } while (!(optionSelected > 0 && optionSelected < 3));

      switch (optionSelected) {
        case 1:
          PatientUser patient = new PatientUser();
          patient.login();
          break;
        case 2:
          newPatient.newPatientRegistration();
          break;
        default:
          System.err.println("Some error occured");
          break;
      }
    } catch (IOException e) {
      System.err.println("I/O ERROR");
    }
  }
}
