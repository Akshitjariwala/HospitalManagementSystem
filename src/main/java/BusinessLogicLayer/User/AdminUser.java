/*
 * CSCI 5308 Group Project
 * @author: Akshit Jariwala
 * @description: This program handles admin Login by
 * validating him/her before giving access to the system
 *
 * */

package BusinessLogicLayer.User;

import PresentationLayer.AdminUI;

import java.util.Scanner;

public class AdminUser extends User {

  @Override
  public void login() {
    int choiceFlag = 0;

    do {
      System.out.println("\n=================================================");
      System.out.println("\t\t\t\tAdmin Login Page\t\t\t");
      System.out.println("=================================================");
      System.out.printf("%n");
      System.out.print("Enter UserId : ");
      Scanner loginInput = new Scanner(System.in);
      String loginID = loginInput.nextLine();
      System.out.print("Enter Password : ");
      Scanner loginPassword = new Scanner(System.in);
      String password = loginPassword.nextLine();

      if (loginID != null && password != null) {
        if (loginID.equals("admin") & password.equals("admin")) {
          AdminUI adminUI = new AdminUI();
          adminUI.adminPage();
        } else {
          System.out.println("\nUser Login ID and Password Doesnt Match. Please Provide Valid Login ID and Password.\n");
        }
      } else {
        System.out.println("\nInvalid Input Received! Please Enter Valid Selection.\n");
      }
    } while (choiceFlag == 0);
  }
}
