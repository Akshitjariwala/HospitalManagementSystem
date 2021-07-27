/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles booking of new appointments
 * once the patient has logged in.
 * The database access is done using common DatabaseConnection class
 *
 */
package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.PatientModule.PatientInterfaces.IBookAppointments;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.PatientAbstractAction;
import PresentationLayer.PatientUI;
import BusinessLogicLayer.BeanClasses.PatientAppointmentWithDoctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookAppointments extends PatientAbstractAction implements IBookAppointments {

  private IBookAppointmentsDAO iBookAppointmentsDAO;
  private static final String ACTION_TITLE = "Book Appointments";
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private ResultSet resultSet = null;
  private Scanner readInput = new Scanner(System.in);
  private String selectedDoctor = null;
  private int appointment = 0;
  private String date = null;
  private String timeSlotSelected = null;
  private int doctorChoice = 0;
  private int timeSlotChoice = 0;
  private String globalPatientID = null;
  private List<String> doctorList = new ArrayList<>();
  private PatientAppointmentWithDoctor appointmentWithDoctor = new PatientAppointmentWithDoctor();
  private static List<String> typeOfAppointmenList = new ArrayList<String>() {{
    add("In Person");
    add("Online Consultation");
  }};
  private static List<String> timeSlotList = new ArrayList<String>() {{
    add("Morning");
    add("Afternoon");
    add("Evening");
  }};

  public BookAppointments() {
    iBookAppointmentsDAO = iPatientActionDatabase.getAppointmentDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  public boolean appointmentBookingPortalofPatient(String patientid) {

    System.out.println("==============================\nBOOK APPOINTMENT\n==============================");

    try {
      System.out.println("Fetching details about available Doctors. One Moment .....");
      TimeUnit.SECONDS.sleep(5);
      displayDoctorList();
      System.out.println("\n");

      //Patient
      globalPatientID = patientid;
      String patientFullName = iBookAppointmentsDAO.getPatientName(patientid);
      appointmentWithDoctor.setPatientName(patientFullName);

      //Select doctor
      Boolean doctorFlag = false;
      do {
        if (doctorChoice != 0 || doctorFlag == true)
          System.err.println("*** Please enter correct doctor prefenence ***\n");

        System.out.println("Select doctor (Option) with whom you want to book an appointment:");
        String x = reader.readLine();
        if (!x.isEmpty()) {
          doctorChoice = Integer.parseInt(x);
        } else {
          doctorChoice = 0;
        }
        doctorFlag = true;
      } while (!(doctorChoice > 0 && doctorChoice <= doctorList.size()));
      appointmentWithDoctor.setDoctorName(doctorList.get(doctorChoice - 1));
      System.out.println("\n\nPlease enter below details to book an appoint with " + appointmentWithDoctor.getDoctorName() + " :");

      //Select type of appointment
      Boolean appointmentFlag = false;
      do {
        if (appointment != 0 || appointmentFlag == true)
          System.err.println("*** Please enter correct Appointment Type ***\n");

        System.out.println("Type of appointment 1)In Person 2) Online Consultation:");
        appointment = Integer.parseInt(reader.readLine());
        appointmentFlag = true;
      } while (!(appointment > 0 && appointment < 3));
      appointmentWithDoctor.setTypeOfAppointment(typeOfAppointmenList.get(appointment - 1));

      //Date
      Boolean dateFlag = false;
      do {
        if (date != null || dateFlag == true)
          System.err.println("*** Please enter correct Date of Appointment  ***\n");

        System.out.println("Date (dd/mm/yyyy):");
        date = reader.readLine();
        dateFlag = true;
      } while (!date.matches("^(0[1-9]|[12][0-9]|3[01])([/])(0[1-9]|1[012])([/])(19|20)\\d\\d$"));
      appointmentWithDoctor.setAppointmentDate(date);

      //Select Time
      do {
        if (timeSlotChoice != 0)
          System.err.println("*** Please enter correct Time Slot ***\n");

        System.out.println("Preferred Time Slot 1)Morning 2) Afternoon 3) Evening:");
        timeSlotChoice = Integer.parseInt(reader.readLine());
      } while (!(timeSlotChoice == 1 || timeSlotChoice == 2 || timeSlotChoice == 3));
      appointmentWithDoctor.setTimeSlot(timeSlotList.get(timeSlotChoice - 1));

      displayEnteredDetails();
    } catch (InterruptedException e) {
      System.out.println("Time ERROR");
      return false;
    } catch (IOException e) {
      System.err.println("I/O ERROR");
    }
    return true;
  }

  public void displayDoctorList() {
    try {
      resultSet = iBookAppointmentsDAO.fetchDoctorList();
      //print doctor list
      System.out.println("|\tOption\t\t|\t\tDoctor Name\t\t|\tSpecialization\t\t|\tExperience\t\t|");
      System.out.println("-------------------------------------------------------------------------");
      int optionIndex = 0;
      while (resultSet.next()) {

        doctorList.add(resultSet.getString(1));
        System.out.println("|\t\t" + ++optionIndex + "\t\t   " + resultSet.getString(1) + "\t\t\t\t" + resultSet.getString(2) + "\t\t\t\t" + resultSet.getDouble(3) + "\t|");
      }
    } catch (SQLException SQL) {
      System.err.println("SQL ERROR");
    }
  }

  public void displayEnteredDetails() {
    System.out.println("\nBelow are you appointment Details:\n");
    System.out.println("1. Patient Name: " + appointmentWithDoctor.getPatientName());
    System.out.println("2. Doctor Name: " + appointmentWithDoctor.getDoctorName());
    System.out.println("3. Date of Appointment: " + appointmentWithDoctor.getAppointmentDate());
    System.out.println("4. Preferred Time Slot: " + appointmentWithDoctor.getTimeSlot());
    System.out.println("5. Type of Appointment: " + appointmentWithDoctor.getTypeOfAppointment());
    System.out.println("6. Confirm Appointment");
    System.out.println("7. Main Menu");
    System.out.println("\nTo change any information, please select from 2-5.\nTo confirm appointment select 6 and select 7 to go back to Main Menu");

    changeEnteredDetails();
  }

  public void changeEnteredDetails() {
    System.out.println("Enter your choice:");
    try {
      int updateChoice = Integer.parseInt(reader.readLine());
      switch (updateChoice) {
        case 2:
          displayDoctorList();
          Boolean doctorFlag = false;
          do {
            if (doctorChoice != 999999 && doctorFlag == true)
              System.err.println("*** Please enter correct doctor preference ***\n");

            System.out.println("Please enter new doctor: ");
            doctorChoice = Integer.parseInt(reader.readLine());
            doctorFlag = true;
          } while (!(doctorChoice > 0 && doctorChoice < doctorList.size()));
          appointmentWithDoctor.setDoctorName(doctorList.get(doctorChoice - 1));
          displayEnteredDetails();
          break;

        case 3:

          Boolean dateFlag = false;
          do {
            if (date != null && dateFlag == true)
              System.err.println("*** Please enter correct Date of Appointment  ***\n");

            System.out.println("Please enter new Date: ");
            date = reader.readLine();
            dateFlag = true;
          } while (!date.matches("^(0[1-9]|[12][0-9]|3[01])([./-])(0[1-9]|1[012])([./-])(19|20)\\d\\d$"));
          appointmentWithDoctor.setAppointmentDate(date);
          displayEnteredDetails();
          break;

        case 4:
          System.out.println("New Time Slot 1)Morning 2) Afternoon 3) Evening:");
          Boolean timeFlag = false;
          do {
            if (timeSlotChoice != 999999 && timeFlag == true)
              System.err.println("*** Please enter correct Time Slot ***\n");

            System.out.println("Preferred Time Slot:");
            timeSlotChoice = Integer.parseInt(reader.readLine());
            timeFlag = true;
          } while (!(timeSlotChoice == 1 || timeSlotChoice == 2 || timeSlotChoice == 3));
          appointmentWithDoctor.setTimeSlot(timeSlotList.get(timeSlotChoice - 1));
          displayEnteredDetails();
          break;

        case 5:
          System.out.println("Type of appointment 1)In Person 2) Online Consultation:");
          Boolean appointmentFlag = false;
          do {
            if (appointment != 999999 && appointmentFlag == true)
              System.err.println("*** Please enter correct Appointment Type ***\n");

            System.out.println("Change Appointment Type: ");
            appointment = Integer.parseInt(reader.readLine());
            appointmentFlag = true;
          } while (!(appointment > 0 && appointment < 3));
          appointmentWithDoctor.setTypeOfAppointment(typeOfAppointmenList.get(appointment - 1));
          displayEnteredDetails();
          break;

        case 6:
          saveEnteredDetails(globalPatientID, appointmentWithDoctor.getDoctorName());
          PatientUI pui = new PatientUI();
          pui.mainPatientUI(globalPatientID, appointmentWithDoctor.getPatientName());

          break;
        case 7:
          PatientUI pui2 = new PatientUI();
          pui2.mainPatientUI(globalPatientID, appointmentWithDoctor.getPatientName());

        default:
          System.err.println("Wrong Input");
          changeEnteredDetails();
          break;
      }
    } catch (IOException e) {
      System.err.println("I/O ERROR !!!");
    }
  }

  public void saveEnteredDetails(String patient, String doctor) {

    Boolean isAppointmentBooked = iBookAppointmentsDAO.saveAppointment(patient, doctor, appointmentWithDoctor);
    if (isAppointmentBooked) {
      System.out.println("\n***** NEW APPOINTMENT CREATED *****");
    }
  }
}
