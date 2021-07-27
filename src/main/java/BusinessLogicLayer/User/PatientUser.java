/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles patient Login
 * of existing patient and validate them before
 * giving access to the system
 *
 * */
package BusinessLogicLayer.User;

import DatabaseLayer.ActionDatabase.Patient.Login.PatientLoginDAO;
import PresentationLayer.PatientUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;


public class PatientUser extends User {

  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private PatientUI patientUI = new PatientUI();

  @Override
  public void login() {
    String userID = null;
    String password = null;
    String providedPassword = null;
    String patientName = null;
    ResultSet resultSet = null;
    PatientLoginDAO patientLoginDAO = new PatientLoginDAO();

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

        providedPassword = patientLoginDAO.getLoginCredentials(userID);
      } while (!password.equals(providedPassword));

      patientName = patientLoginDAO.getPatientName(userID);

      //Redirect to mainPatientUI
      patientUI.mainPatientUI(userID, patientName);

    } catch (IOException e) {
      System.out.println("I/O ERROR");
    }
  }


}
