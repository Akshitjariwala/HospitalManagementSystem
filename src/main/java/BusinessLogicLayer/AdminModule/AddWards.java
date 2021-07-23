/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Ward;
import BusinessLogicLayer.WardModule.WardHome;
import DatabaseLayer.Dao.AddWardsDAO;

import java.util.Scanner;


public class AddWards {

  public static void addWards() {

    Ward ward = new Ward();
    Scanner inputData = new Scanner(System.in);
    System.out.println("============================================================================");
    System.out.println("                      Add Wards");
    System.out.println("============================================================================");

    do {
      System.out.println("Ward Name :");
      String wardName = inputData.nextLine();
      if (wardName.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setWardName(wardName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getWardName() == null);

    do {
      System.out.println("Ward Location :");
      String location = inputData.nextLine();
      if (location.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setLocation(location);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getLocation() == null);

    do {
      System.out.println("Bed Type :");
      String bedType = inputData.nextLine();
      if (bedType.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setBedType(bedType);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getBedType() == null);

    do {
      System.out.println("Total Beds :");
      int totalBeds = inputData.nextInt();
      if (totalBeds > 0) {
        ward.setTotalBeds(totalBeds);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getTotalBeds() == 0);

    do {
      System.out.println("Ward Type(Covid/Non-Covid/General/Children/Emergency) :");
      String wardType = inputData.next();
      if (wardType.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setWardType(wardType);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getWardType() == null);
    AddWardsDAO addWardsDAO = new AddWardsDAO();
    int status = addWardsDAO.addWard(ward);
    if (status == 1) {
      System.out.println("Ward details added successfully");
    } else {
      System.out.println("ERROR while adding ward");
    }
    WardHome wardHome = new WardHome();
    wardHome.wardManageHomePage();
  }
}
