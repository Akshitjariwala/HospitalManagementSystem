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
        String patientName=null;
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
                String query="SELECT lc.password as login_password,concat(first_name,' ', last_name) as patient_name from patients pt join login_cred lc\n" +
                        " where pt.patient_id='"+userID+"' and lc.userid='"+userID+"'";
                resultSet=statement.executeQuery(query);
                while (resultSet.next()){
                    providedPassword=resultSet.getString(1);
                    patientName=resultSet.getString(2);
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }while (!password.equals(providedPassword));

        System.out.println("Welcome "+patientName);
    }

    public static void main(String[] args) {
        PatientLogin patientLogin=new PatientLogin();
        patientLogin.patientLogin();
    }
}
