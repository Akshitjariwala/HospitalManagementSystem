/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles new patient registration,
 * and also handles login process of patient.
 * The database access is done using common DatabaseConnection class
 *
 * */

package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UpdatePersonalDetails {

    private static DatabaseConnection databaseConnection=DatabaseConnection.createInstance();

    private  static Connection connection=databaseConnection.openDBConnection();
    private Statement statement=null;
    private Scanner readInput=new Scanner(System.in);
    private Patient patient=new Patient();

    private String firstName=null;
    private String lastName=null;
    private String middleName=null;
    private String emaiID=null;
    private String phoneNumber=null;
    private String address=null;
    private String cityName=null;
    private String stateName=null;
    private String typeOfPatient=null;
    private String emergencyContactName=null;
    private String emergencyContactNumber=null;
    private String additionalComments=null;
    private String userID=null;
    private String password=null;

    public void newPatientRegistration(){


        System.out.println("===========================================\n" +
                "\t\t\t\tPatient Registration\n" +
                "===========================================\n");
        System.out.println("Please enter below details\n" +
                "Note: * fields are mandatory");
        //First Name
        do{
            if(firstName!=null)
                System.out.println("*** Please enter your first Name ***");

            System.out.println("First Name *:");
            firstName=readInput.nextLine();
        }while (!firstName.matches("[A-Za-z]+"));
        patient.setFirstName(firstName);

        //Last Name
        do{
            if(lastName!=null)
                System.out.println("*** Please enter your last Name ***");

            System.out.println("Last Name *:");
            lastName=readInput.nextLine();
        }while (!lastName.matches("[A-Za-z]+"));
        patient.setLastName(lastName);

        //Middle Name
        System.out.println("Middle Name:");
        middleName=readInput.nextLine();
        patient.setMiddleName(middleName);

        //Email
        do{
            if(emaiID!=null)
                System.out.println("*** Please enter correct Email ID ***");

            System.out.println("Email ID *:");
            emaiID=readInput.nextLine();
        }while (!emaiID.matches("^(.+)@(.+)$"));
        patient.setEmaiID(emaiID);

        //Phone Number
        do{
            if(phoneNumber!=null)
                System.out.println("*** Please enter correct number ***");

            System.out.println("Contact Number *:");
            phoneNumber=readInput.nextLine();
        }while (!phoneNumber.matches("^\\d+$"));
        patient.setPhoneNumber(phoneNumber);

        //Address
        System.out.println("Address:");
        address=readInput.nextLine();
        patient.setAddress(address);

        //City
        do{
            if(cityName!=null)
                System.out.println("*** Please enter your city ***");

            System.out.println("City *:");
            cityName=readInput.nextLine();
        }while (!cityName.matches("[A-Za-z]+"));
        patient.setCityName(cityName);

        //State
        do{
            if(stateName!=null)
                System.out.println("*** Please enter your State ***");

            System.out.println("State *:");
            stateName=readInput.nextLine();
        }while (!stateName.matches("[A-Za-z]+"));
        patient.setStateName(stateName);

        //Emergency Contact Details
        System.out.println("Emergency Contact Name:");
        emergencyContactName=readInput.nextLine();
        patient.setEmergencyContactName(emergencyContactName);
        System.out.println("Emergency Contact Number:");
        emergencyContactNumber=readInput.nextLine();
        patient.setEmergencyContactNumber(emergencyContactNumber);


        //User ID
        do{
            if(userID!=null)
                System.out.println("*** Please enter your user ID ***");

            System.out.println("User ID *:");
            userID=readInput.nextLine();
        }while (!stateName.matches("[A-Za-z0-9]+"));
        patient.setUserID(userID);

        //Password
        do{
            if(password!=null)
                System.out.println("*** Invalid password\n" +
                        "Must have at least 1 lower & upper letter\n" +
                        "Must have one special symbol (!@#$%^&()=+)\n" +
                        "Must be 8 to 20 characters ***");

            System.out.println("Password *:");
            password=readInput.nextLine();
        }while (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()=+])(?=.*\\S+$).{8,20}$"));
        patient.setPassword(password);

        displaynewPatientdetails();

    }
    private void displaynewPatientdetails(){
        System.out.println("\nBelow are the details given:\n");
        System.out.println("1. Last name: "+patient.getLastName());
        System.out.println("2. First name: "+patient.getFirstName());
        System.out.println("3. Middle name: "+patient.getMiddleName());
        System.out.println("4. Email: "+patient.getEmaiID());
        System.out.println("5. Phone Number: "+patient.getPhoneNumber());
        System.out.println("6. Emergency Contact Name:"+patient.getEmergencyContactName());
        System.out.println("7. Emergency Contact Number:"+patient.getEmergencyContactNumber());
        System.out.println("8. Address: "+patient.getAddress());
        System.out.println("9. City: "+patient.getCityName());
        System.out.println("10. State: "+patient.getStateName());
        System.out.println("11. UserID: "+patient.getUserID());
        System.out.println("12. Password: "+patient.getPassword());
        System.out.println("13. Save the details");
        System.out.println("14. Main Menu ");
        System.out.println("\nTo change or update the provided details, enter a number between 1-11.\nTo save the details enter 16 and to go back to Main menu select 13");
        changeEnteredDetails();
    }
    private void changeEnteredDetails(){
        System.out.println("Enter your choice:");
        int updateChoice=readInput.nextInt();

            switch (updateChoice) {

                case 1:
                    System.out.println("Enter new Last Name: ");
                    lastName = readInput.next();
                    patient.setLastName(lastName);
                    displaynewPatientdetails();
                    break;

                case 2:
                    System.out.println("Enter new First Name: ");
                    firstName = readInput.next();
                    patient.setFirstName(firstName);
                    displaynewPatientdetails();
                    break;

                case 3:
                    System.out.println("Enter new Middle Name: ");
                    middleName = readInput.next();
                    patient.setMiddleName(middleName);
                    displaynewPatientdetails();
                    break;

                case 4:
                    System.out.println("Enter new Email: ");
                    emaiID =readInput.next();
                    patient.setEmaiID(emaiID);
                    
                    displaynewPatientdetails();
                    break;

                case 5:
                    System.out.println("Enter new Phone Number: ");
                    phoneNumber = readInput.next();
                    patient.setPhoneNumber(phoneNumber);
                    displaynewPatientdetails();
                    break;

                case 6:
                    System.out.println("Enter new Emergency Contact Name: ");
                    emergencyContactName = readInput.next();
                    patient.setEmergencyContactName(emergencyContactName);
                    
                    displaynewPatientdetails();
                    break;

                case 7:
                    System.out.println("Enter new Emergency Contact Number: ");
                    emergencyContactNumber = readInput.next();
                    patient.setEmergencyContactNumber(emergencyContactNumber);
                    
                    displaynewPatientdetails();
                    break;

                case 8:
                    System.out.println("Enter new Address: ");
                    address =readInput.next();
                    patient.setAddress(address);
                    displaynewPatientdetails();
                    break;

                case 9:
                    System.out.println("Enter new City: ");
                    cityName = readInput.next();
                    patient.setCityName(cityName);
                    
                    displaynewPatientdetails();
                    break;

                case 10:
                    System.out.println("Enter new State: ");
                    stateName = readInput.next();
                    patient.setStateName(stateName);
                    
                    displaynewPatientdetails();
                    break;

                case 11:
                    System.out.println("Enter new UserID: ");
                    userID = readInput.next();
                    patient.setUserID(userID);
                    
                    displaynewPatientdetails();
                    break;

                case 12:
                    System.out.println("Enter new Password: ");
                    password =readInput.next();
                    patient.setPassword(password);
                    
                    displaynewPatientdetails();
                    break;

                case 13:
                    saveNewPatient();
                    System.out.println("NEW PATIENT CREATED");
                    break;

                case 14:
                    //Main Menu
                    break;

                default:
                    System.err.println("Wrong choice. Select proper");
                    changeEnteredDetails();
            }
    }
    private void saveNewPatient(){
         try {
            statement=connection.createStatement();
            String query1 = "INSERT INTO patients (patient_id, password, last_name, first_name, middle_name, email, phone_number, address, city, state, type_of_patient, emg_contact_name, emg_contact_phone)" +
                    "VALUES ('"+patient.getUserID()+"','"+patient.getPassword()+"','"+patient.getLastName()+"','"+patient.getFirstName()+"','"+patient.getMiddleName()+"','"+patient.getEmaiID()+"','"+patient.getPhoneNumber()+"','"+patient.getAddress()+"','"+patient.getCityName()+"','"+patient.getStateName()+"','Patient','"+patient.getEmergencyContactName()+"','"+patient.getEmergencyContactNumber()+ "');";
           //  statement.executeUpdate(query1);
            String query2="INSERT INTO login_cred VALUES ('"+patient.getUserID()+"','"+patient.getPassword()+"','Patient');";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public void patientLogin(){
        String userID=null;
        String password=null;
        String providedPassword=null;
        ResultSet resultSet=null;

        System.out.println("===========================================\n" +
                "\t\t\t\tPatient Login\n" +
                "===========================================\n");
        do{
            if(userID!=null || password!=null)
                System.out.println("*** Invalid user ID or Password ***");

            System.out.println("User ID:");
            userID=readInput.nextLine();
            System.out.println("Password:");
            password=readInput.nextLine();

            try{
                statement=connection.createStatement();
                resultSet=statement.executeQuery("SELECT password FROM login_cred WHERE userid='"+userID+"';");
                while (resultSet.next()){
                    providedPassword=resultSet.getString(1);
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }while (!password.equals(providedPassword));
        System.out.println("Welcome "+userID);
    }

    public static void main(String[] args) {
        UpdatePersonalDetails updatePersonalDetails=new UpdatePersonalDetails();
        updatePersonalDetails.newPatientRegistration();

    }
}

