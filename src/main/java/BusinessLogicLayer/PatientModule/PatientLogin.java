package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PatientLogin {


    private static DatabaseConnection databaseConnection=DatabaseConnection.createInstance();

    private  static Connection connection=databaseConnection.openDBConnection();
    private Statement statement=null;
    private Scanner readInput=new Scanner(System.in);

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
        PatientLogin patientLogin=new PatientLogin();
        patientLogin.patientLogin();
    }
}
