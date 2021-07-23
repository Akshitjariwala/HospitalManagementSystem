package PresentationLayer;

import BusinessLogicLayer.PatientModule.BookAppointments;
import BusinessLogicLayer.PatientModule.PatientLogin;
import BusinessLogicLayer.PatientModule.PatientRegistration;
import BusinessLogicLayer.PatientModule.ViewPatientReports;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatientUI {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public void mainPatientUI(String patientID, String patientName) {

    BookAppointments appointments = new BookAppointments();
    ViewPatientReports viewPatientReports = new ViewPatientReports();

    int optionSelected = 0;

    System.out.println("Welcome *******" + patientName + "*******\n\n");

    System.out.println("1. Book Appointment");
    System.out.println("2. View Lab Reports");
    try {
      Boolean optionFlag = false;
      do {
        if ((optionSelected != 999999) && optionFlag == true)
          System.err.println("*** Please choose either 1 or 2***\n");

        System.out.println("Select Option:");
        String input=reader.readLine();
        if (input!= null && !input.isEmpty()) {
          optionSelected = Integer.parseInt(input);
          optionFlag = true;
        }
      } while (!(optionSelected > 0 && optionSelected < 3));

      switch (optionSelected) {
        case 1:
          appointments.appointmentBookingPortalofPatient(patientID);
          break;

        case 2:
          viewPatientReports.viewLabReports(patientID);
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
    PatientLogin patientLogin = new PatientLogin();
    int optionSelected = 0;
    System.out.println("==============================\n\t\tType of Patient\n==============================\n");
    System.out.println("1. Existing Patient");
    System.out.println("2. New Patient");
    try {
      Boolean optionFlag = false;
      do {
        if (optionSelected != 999999 && optionFlag == true)
          System.err.println("\n*** Please choose either 1 or 2***\n");

        System.out.println("Select Option:");
        optionSelected = Integer.parseInt(reader.readLine());
        optionFlag = true;
      } while (!(optionSelected > 0 && optionSelected < 3));

      switch (optionSelected) {
        case 1:
          patientLogin.patientLogin();
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
