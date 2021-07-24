/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles login process of patients i.e.
 * it verifies if a patient is registered in the system or not.
 * The database access is done using common DatabaseConnection class
 *
 * */

package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.PatientModule.PatientInterfaces.LoginInterface;
import DatabaseLayer.Dao.PatientLoginDAO;
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

public class PatientLogin implements LoginInterface {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private PatientUI patientUI = new PatientUI();

  public void patientLogin() {
    String userID = null;
    String password = null;
    String providedPassword = null;
    String patientName = null;
    ResultSet resultSet = null;
    PatientLoginDAO patientLoginDAO=new PatientLoginDAO();

    System.out.println("\n===========================================\n" +
            "\t\t\t\tPatient Login\n" +
            "===========================================\n");
    try {
      do {
        if (userID != null || password != null)
          System.err.println("\n*** Invalid user ID or Password ***\n");

        System.out.print("Enter User ID : ");
        userID = reader.readLine();
        System.out.print("Enter Password : ");
        password = reader.readLine();

        providedPassword=patientLoginDAO.getLoginCredentials(userID);
      } while (!password.equals(providedPassword));

      patientName=patientLoginDAO.getPatientName(userID);

      //Redirect to mainPatientUI
      patientUI.mainPatientUI(userID, patientName);

    } catch (IOException e) {
      System.out.println("I/O ERROR");
    }
  }
}
