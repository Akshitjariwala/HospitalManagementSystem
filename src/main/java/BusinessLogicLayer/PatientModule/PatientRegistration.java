/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles new patient registration.
 * The database access is done using common DatabaseConnection class
 *
 * */

package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.BeanClasses.Patient;
import BusinessLogicLayer.PatientModule.PatientInterfaces.IPatientRegistration;
import DatabaseLayer.ActionDatabase.Patient.PatientAbstractAction;
import DatabaseLayer.ActionDatabase.Patient.Registration.IPatientRegistrationDAO;
import PresentationLayer.PatientUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class PatientRegistration extends PatientAbstractAction implements IPatientRegistration {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private Patient patient = new Patient();
  private IPatientRegistrationDAO iPatientRegistrationDAO;
  private static final String ACTION_TITLE = "Patient Registration";
  private String firstName = null;
  private String lastName = null;
  private String middleName = null;
  private String emaiID = null;
  private String phoneNumber = null;
  private String address = null;
  private String cityName = null;
  private String stateName = null;
  private String typeOfPatient = null;
  private String emergencyContactName = null;
  private String emergencyContactNumber = null;
  private String additionalComments = null;
  private String userID = null;
  private String password = null;


  public PatientRegistration() {
    iPatientRegistrationDAO = iPatientActionDatabase.registerPatientDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  public void newPatientRegistration() {

    try {
      System.out.println("===========================================\n" +
              "\t\t\t\tPatient Registration\n" +
              "===========================================\n");
      System.out.println("Please enter below details\n" +
              "Note: * fields are mandatory");
      //First Name
      do {
        if (firstName != null)
          System.err.println("*** Please enter your first Name ***\n");

        System.out.println("First Name *:");
        firstName = reader.readLine();
      } while (!firstName.matches("[A-Za-z]+"));
      patient.setFirstName(firstName);

      //Last Name
      do {
        if (lastName != null)
          System.err.println("*** Please enter your last Name ***\n");

        System.out.println("Last Name *:");
        lastName = reader.readLine();
      } while (!lastName.matches("[A-Za-z]+"));
      patient.setLastName(lastName);

      //Middle Name
      System.out.println("Middle Name:");
      middleName = reader.readLine();
      patient.setMiddleName(middleName);

      //Email
      do {
        if (emaiID != null)
          System.err.println("*** Please enter correct Email ID ***\n");

        System.out.println("Email ID *:");
        emaiID = reader.readLine();
      } while (!emaiID.matches("^(.+)@(.+)$"));
      patient.setEmaiID(emaiID);

      //Phone Number
      do {
        if (phoneNumber != null)
          System.err.println("*** Please enter correct number ***\n");

        System.out.println("Contact Number *:");
        phoneNumber = reader.readLine();
      } while (!phoneNumber.matches("^\\d+$"));
      patient.setPhoneNumber(phoneNumber);

      //Address
      System.out.println("Address:");
      address = reader.readLine();
      patient.setAddress(address);

      //City
      do {
        if (cityName != null)
          System.err.println("*** Please enter your city ***\n");

        System.out.println("City *:");
        cityName = reader.readLine();
      } while (!cityName.matches("[A-Za-z]+"));
      patient.setCityName(cityName);

      //State
      do {
        if (stateName != null)
          System.err.println("*** Please enter your State ***\n");

        System.out.println("State *:");
        stateName = reader.readLine();
      } while (!stateName.matches("[A-Za-z]+"));
      patient.setStateName(stateName);

      //Emergency Contact Details
      System.out.println("Emergency Contact Name:");
      emergencyContactName = reader.readLine();
      patient.setEmergencyContactName(emergencyContactName);
      System.out.println("Emergency Contact Number:");
      emergencyContactNumber = reader.readLine();
      patient.setEmergencyContactNumber(emergencyContactNumber);


      //User ID
      do {
        if (userID != null)
          System.err.println("*** Please enter your user ID ***\n");

        System.out.println("User ID *:");
        userID = reader.readLine();
      } while (!stateName.matches("[A-Za-z0-9]+"));
      patient.setUserID(userID);

      //Password
      do {
        if (password != null)
          System.err.println("*** Invalid password\n" +
                  "Must have at least 1 lower & upper letter\n" +
                  "Must have one special symbol (!@#$%^&()=+)\n" +
                  "Must be 8 to 20 characters ***\n");

        System.out.println("Password *:");
        password = reader.readLine();
      } while (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()=+])(?=.*\\S+$).{8,20}$"));
      patient.setPassword(password);
    } catch (IOException e) {
      System.out.println("I/O ERROR");
    }
    displayEnteredDetails();
  }

  public void displayEnteredDetails() {
    System.out.println("\nBelow are the details given:\n");
    System.out.println("1. Last name: " + patient.getLastName());
    System.out.println("2. First name: " + patient.getFirstName());
    System.out.println("3. Middle name: " + patient.getMiddleName());
    System.out.println("4. Email: " + patient.getEmaiID());
    System.out.println("5. Phone Number: " + patient.getPhoneNumber());
    System.out.println("6. Emergency Contact Name:" + patient.getEmergencyContactName());
    System.out.println("7. Emergency Contact Number:" + patient.getEmergencyContactNumber());
    System.out.println("8. Address: " + patient.getAddress());
    System.out.println("9. City: " + patient.getCityName());
    System.out.println("10. State: " + patient.getStateName());
    System.out.println("11. UserID: " + patient.getUserID());
    System.out.println("12. Password: " + patient.getPassword());
    System.out.println("13. Save the details");
    System.out.println("14. Main Menu ");
    System.out.println("\nTo change or update the provided details, enter a number between 1-11.\nTo save the details enter 16 and to go back to Main menu select 13");
    changeEnteredDetails();
  }


  public void changeEnteredDetails() {
    String X = null;
    try {
      do {
        if (X != null) {
          System.err.println("*** Please enter correct choice between 1-14 ***\n");
        }
        System.out.println("Enter your choice:");
        X = reader.readLine();
      } while (!X.matches("(1|2|3|4|5|6|7|8|9|10|11|12|13|14)"));
      int updateChoice = Integer.parseInt(X);
      switch (updateChoice) {

        case 1:
          Boolean lastNameFlag = false;
          do {
            if (lastName != null && lastNameFlag == true)
              System.err.println("*** Please enter your last Name ***\n");

            System.out.println("Enter new Last Name: ");
            lastName = reader.readLine();
            lastNameFlag = true;
          } while (!lastName.matches("[A-Za-z]+"));
          patient.setLastName(lastName);
          displayEnteredDetails();
          break;

        case 2:
          Boolean firstNameFlag = false;
          do {
            if (firstName != null && firstNameFlag == true)
              System.err.println("*** Please enter your first Name ***\n");

            System.out.println("Enter new First Name: ");
            firstName = reader.readLine();
            firstNameFlag = true;
          } while (!firstName.matches("[A-Za-z]+"));
          patient.setFirstName(firstName);
          displayEnteredDetails();
          break;

        case 3:
          System.out.println("Enter new Middle Name: ");
          middleName = reader.readLine();
          patient.setMiddleName(middleName);
          displayEnteredDetails();
          break;

        case 4:
          Boolean emailFlag = false;
          do {
            if (emaiID != null && emailFlag == true)
              System.err.println("*** Please enter correct Email ID ***\n");

            System.out.println("Enter new Email: ");
            emaiID = reader.readLine();
            emailFlag = true;
          } while (!emaiID.matches("^(.+)@(.+)$"));
          patient.setEmaiID(emaiID);
          displayEnteredDetails();
          break;

        case 5:
          System.out.println("Enter new Phone Number: ");
          phoneNumber = reader.readLine();
          patient.setPhoneNumber(phoneNumber);
          displayEnteredDetails();
          break;

        case 6:
          System.out.println("Enter new Emergency Contact Name: ");
          emergencyContactName = reader.readLine();
          patient.setEmergencyContactName(emergencyContactName);
          displayEnteredDetails();
          break;

        case 7:
          System.out.println("Enter new Emergency Contact Number: ");
          emergencyContactNumber = reader.readLine();
          patient.setEmergencyContactNumber(emergencyContactNumber);
          displayEnteredDetails();
          break;

        case 8:

          System.out.println("Enter new Address: ");
          address = reader.readLine();
          patient.setAddress(address);
          displayEnteredDetails();
          break;

        case 9:
          Boolean cityNameFlag = false;
          do {
            if (cityName != null && cityNameFlag == true)
              System.err.println("*** Please enter your city ***\n");

            System.out.println("Enter new City: ");
            cityName = reader.readLine();
            cityNameFlag = true;
          } while (!cityName.matches("[A-Za-z]+"));
          patient.setCityName(cityName);

          displayEnteredDetails();
          break;

        case 10:
          Boolean stateFlag = false;
          do {
            if (stateName != null && stateFlag == true)
              System.err.println("*** Please enter your State ***\n");

            System.out.println("Enter new State: ");
            stateName = reader.readLine();
            stateFlag = true;
          } while (!stateName.matches("[A-Za-z]+"));
          patient.setStateName(stateName);
          displayEnteredDetails();
          break;

        case 11:
          Boolean userIDFlag = false;
          do {
            if (userID != null && userIDFlag == true)
              System.err.println("*** Please enter your user ID ***\n");

            System.out.println("Enter new UserID: ");
            userID = reader.readLine();
            userIDFlag = true;
          } while (!stateName.matches("[A-Za-z0-9]+"));
          patient.setUserID(userID);
          displayEnteredDetails();
          break;

        case 12:
          Boolean passFlag = false;
          do {
            if (password != null && passFlag == true)
              System.err.println("*** Invalid password\n" +
                      "Must have at least 1 lower & upper letter\n" +
                      "Must have one special symbol (!@#$%^&()=+)\n" +
                      "Must be 8 to 20 characters ***\n");

            System.out.println("Enter new Password: ");
            password = reader.readLine();
            passFlag = true;
          } while (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()=+])(?=.*\\S+$).{8,20}$"));
          patient.setPassword(password);
          displayEnteredDetails();
          break;

        case 13:
          saveEnteredDetails();
          PatientUI patientUI = new PatientUI();
          patientUI.loginOrRegistrationUI();
          break;

        case 14:
          //Main Menu
          break;

        default:
          System.err.println("Wrong choice. Select proper");
          changeEnteredDetails();
      }
    } catch (IOException e) {
    }
  }

  public void saveEnteredDetails() {

    int isNewPatientCreated = iPatientRegistrationDAO.savePatientDetails(patient);
    if (isNewPatientCreated == 1) {
      System.out.println("\n***** NEW PATIENT CREATED *****");
    } else if (isNewPatientCreated == -1) {
      try {
        System.err.println("***** Username already exists *****\n");
        TimeUnit.SECONDS.sleep(2);
        displayEnteredDetails();
      } catch (InterruptedException e) {
        System.err.println("INTERRUPTED");
      }
    } else {
      System.out.println("\n***** UNABLE TO CREATE NEW PATIENT *****\n");
    }
  }
}

