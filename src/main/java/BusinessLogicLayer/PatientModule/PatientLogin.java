/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles login process of patients i.e.
 * it verifies if a patient is registered in the system or not.
 * The database access is done using common DatabaseConnection class
 *
 * */

package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import PresentationLayer.PatientUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PatientLogin {


  private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();

  private static Connection connection = databaseConnection.openDBConnection();
  private Statement statement = null;
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private PatientUI patientUI = new PatientUI();

  public void patientLogin() {
    String userID = null;
    String password = null;
    String providedPassword = null;
    String patientName = null;
    ResultSet resultSet = null;

    System.out.println("===========================================\n" +
            "\t\t\t\tPatient Login\n" +
            "===========================================\n");
    try {
      do {
        if (userID != null || password != null)
          System.err.println("\n*** Invalid user ID or Password ***\n");

        System.out.println("User ID:");
        userID = reader.readLine();
        System.out.println("Password:");
        password = reader.readLine();


        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT password FROM login_cred WHERE userid='" + userID + "';");
        while (resultSet.next()) {
          providedPassword = resultSet.getString(1);
        }
      } while (!password.equals(providedPassword));

      statement = connection.createStatement();
      String queryToGetPatientName = "SELECT CONCAT(first_name,' ',last_name) FROM CSCI5308_6_DEVINT.patients where patient_id='" + userID + "';";
      resultSet = statement.executeQuery(queryToGetPatientName);
      while (resultSet.next()) {
        patientName = resultSet.getString(1);
      }

      //Redirect to mainPatientUI
      patientUI.mainPatientUI(userID, patientName);

    } catch (IOException e) {
      System.out.println("I/O ERROR");
    } catch (SQLException e) {
      System.out.println("SQL ERROR");
    }
  }
}
