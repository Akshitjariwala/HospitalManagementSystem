/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles new patient registration,
 * and also handles login process of patient.
 *
 * */

package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdatePersonalDetails {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public Statement statement=null;
    private Scanner readInput=new Scanner(System.in);

    //Close Connection
    /*
    private void establishConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("successfull JDBC Driver !!!!");
        }

        //handle jdbc connection errors
        catch (Exception ex) {

            System.out.println("Error in jdbc Driver");
        }

        // Establish connection
        try{
            String hostname="jdbc:mysql://db-5308.cs.Dal.ca:3306/CSCI5308_6_DEVINT";
            String user="CSCI5308_6_DEVINT_USER";
            String password="ZD8gnU7BsJR";
            connection = DriverManager.getConnection(hostname,user,password);
            System.out.println("\nSuccessfull connection to DB ! ! !");
            statement=connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    */
    //Close Connection
    /*
    private  void closeConnection(){
        try{
            if (connection!=null){
                connection.close();
                statement.close();;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    */
    public void newPatientRegistration(){
        String firstName=null;
        String lastName=null;
        String middleName=null;
        String emaiID=null;
        String phoneNumber=null;
        String address=null;
        String cityName=null;
        String stateName=null;
        String typeOfPatient=null;
        String emergencyContactName=null;
        String emergencyContactNumber=null;
        String additionalComments=null;
        String userID=null;
        String password=null;

        //First Name
        do{
            if(firstName!=null)
                System.out.println("*** Please enter your first Name ***");

            System.out.println("First Name *:");
            firstName=readInput.nextLine();
        }while (!firstName.matches("[A-Za-z]+"));

        //Last Name
        do{
            if(lastName!=null)
                System.out.println("*** Please enter your last Name ***");

            System.out.println("Last Name *:");
            lastName=readInput.nextLine();
        }while (!lastName.matches("[A-Za-z]+"));

        //Middle Name
        System.out.println("Middle Name:");
        lastName=readInput.nextLine();

        //Email
        do{
            if(emaiID!=null)
                System.out.println("*** Please enter correct Email ID ***");

            System.out.println("Email ID *:");
            emaiID=readInput.nextLine();
        }while (!emaiID.matches("^(.+)@(.+)$")); // https://howtodoinjava.com/java/regex/java-regex-validate-email-address/#:~:text=Let%E2%80%99s%20directly%20jump%20into%20main%20discussion%20i.e.%20to,a%20quick%20example%20to%20see%20what%20I%20mean.

        //Phone Number
        do{
            if(phoneNumber!=null)
                System.out.println("*** Please enter correct number ***");

            System.out.println("Contact Number *:");
            phoneNumber=readInput.nextLine();
        }while (!phoneNumber.matches("^\\d{10,12}$"));

        //Address
        System.out.println("Address:");
        address=readInput.nextLine();

        //City
        do{
            if(cityName!=null)
                System.out.println("*** Please enter your city ***");

            System.out.println("City *:");
            cityName=readInput.nextLine();
        }while (!cityName.matches("[A-Za-z]+"));

        //City
        do{
            if(stateName!=null)
                System.out.println("*** Please enter your State ***");

            System.out.println("State *:");
            stateName=readInput.nextLine();
        }while (!stateName.matches("[A-Za-z]+"));

        //Emergency Contact Details
        System.out.println("Emergency Contact:");
        emergencyContactName=readInput.nextLine();
        System.out.println("Emergency Contact Number:");
        emergencyContactNumber=readInput.nextLine();

        //Additional Comments
//        System.out.println("Additional Comment:");
//        additionalComments=readInput.nextLine();

        //User ID
        do{
            if(userID!=null)
                System.out.println("*** Please enter your user ID ***");

            System.out.println("User ID *:");
            userID=readInput.nextLine();
        }while (!stateName.matches("[A-Za-z0-9]+"));

        //Password
        do{
            if(password!=null)
                System.out.println("*** Invalid password\n" +
                        "Must have at least 1 lower & upper letter\n" +
                        "Must have one special symbol (!@#$%^&()=+)\n" +
                        "Must be 8 to 20 characters ***");

            System.out.println("Password *:");
            stateName=readInput.nextLine();
        }while (!stateName.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&()=+])(?=.*\\S+$).{8,20}$"));

        //establishConnection();
        try {
            statement=connection.createStatement();
            String query1 = "INSERT INTO patients (patient_id, password, last_name, first_name, middle_name, email, phone_number, address, city, state, type_of_patient, emg_contact_name, emg_contact_phone)" +
                    "VALUES ('"+userID+"','"+password+"','"+lastName+"','"+firstName+"','"+middleName+"','"+emaiID+"','"+phoneNumber+"','"+address+"','"+cityName+"','"+stateName+"','"+typeOfPatient+"','"+emergencyContactName+"','"+emergencyContactNumber+ "');";

            String query2="INSERT INTO login_cred VALUES ('"+userID+"','"+password+"','patient');";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();

        }
        catch (Exception E){
            E.printStackTrace();
        }
        //  closeConnection();
        databaseConnection.closeDBConnection();
    }

    public void patientLogin(){
        String userID=null;
        String password=null;
        String providedPassword=null;
        ResultSet resultSet=null;

        //establishConnection();
        do{
            if(userID!=null)
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

      //  closeConnection();
        databaseConnection.closeDBConnection();
    }
    public static void main(String[] args) {
        UpdatePersonalDetails patient=new UpdatePersonalDetails();
        //patient.newPatientRegistration();
        patient.patientLogin();
       // patient.establishConnection();
        //patient.closeConnection();

    }
}

