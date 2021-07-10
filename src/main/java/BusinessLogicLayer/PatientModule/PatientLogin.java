package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientLogin {


    private static DatabaseConnection databaseConnection=DatabaseConnection.createInstance();

    private  static Connection connection=databaseConnection.openDBConnection();
    private Statement statement=null;
    private Scanner readInput=new Scanner(System.in);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void patientLogin(){
        String userID=null;
        String password=null;
        String providedPassword=null;
        ResultSet resultSet=null;

        System.out.println("===========================================\n" +
                "\t\t\t\tPatient Login\n" +
                "===========================================\n");
       try {
           do {
               if (userID != null || password != null)
                   System.out.println("*** Invalid user ID or Password ***");

               System.out.println("User ID:");
               userID =reader.readLine();
               System.out.println("Password:");
               password = reader.readLine();

               try {
                   statement = connection.createStatement();
                   resultSet = statement.executeQuery("SELECT password FROM login_cred WHERE userid='" + userID + "';");
                   while (resultSet.next()) {
                       providedPassword = resultSet.getString(1);
                   }
               } catch (Exception E) {
                   E.printStackTrace();
               }
           } while (!password.equals(providedPassword));
           System.out.println("Welcome " + userID);
       }catch (IOException e){
           System.out.println("I/O ERROR");
       }
    }

    public static void main(String[] args) {
        PatientLogin patientLogin=new PatientLogin();
        patientLogin.patientLogin();
    }
}
