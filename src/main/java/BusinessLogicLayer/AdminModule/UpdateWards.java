/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Ward;
import BusinessLogicLayer.WardModule.WardHome;
import DatabaseLayer.Dao.UpdateWardsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateWards {

  private static String updateStr = "";

  public static void updateWards() throws SQLException, ClassNotFoundException {
    System.out.println("Enter the id of the ward that has to be updated");
    Scanner scanner = new Scanner(System.in);
    int id = scanner.nextInt();
    UpdateWardsDAO updateWardsDAO = new UpdateWardsDAO();
    Ward ward = updateWardsDAO.getWardDetails(id);
    int wardId = ward.getWardId();

    System.out.println("===========The details of the ward" + " " + wardId + "are==================");
    System.out.println("1. Ward Type :" + ward.getWardType());
    System.out.println("2. Ward Name :" + ward.getWardName());
    System.out.println("3. Ward Location :" + ward.getLocation());
    System.out.println("4. Total Beds :" + ward.getTotalBeds());
    System.out.println("5. Bed Type :" + ward.getBedType());
    System.out.println("6. Go to Ward Management");
    System.out.printf("%n");
    System.out.print("Enter Selection : ");
    int input = scanner.nextInt();
    switch (input) {
      case 1:
        System.out.println("Enter Ward Type :");
        String wardType = scanner.next();
        updateStr = "ward_type = " + "'" + wardType + "'";
        break;
      case 2:
        System.out.println("Enter Ward Name :");
        String wardName = scanner.next();
        updateStr = "name = " + "'" + wardName + "'";
        break;
      case 3:
        System.out.println("Enter Ward Location :");
        String wardLocation = scanner.next();
        updateStr = "location = " + "'" + wardLocation + "'";
        break;
      case 4:
        System.out.println("Enter Total Beds :");
        String totalBeds = scanner.next();
        updateStr = "total_beds = " + totalBeds;
        break;
      case 5:
        System.out.println("Enter Bed Type :");
        String bedType = scanner.next();
        updateStr = "bed_type = " + "'" + bedType + "'";
        break;
      case 6:
        WardHome wardHome = new WardHome();
        wardHome.wardManageHomePage();
        break;
      default:
        System.out.println("Invalid Input, Please choose valid input ");
    }
    if (!updateStr.isEmpty()) {
      updateWardsDAO = new UpdateWardsDAO();
      updateWardsDAO.updateWard(updateStr, wardId);
      System.out.println("Ward Details updated Successfully.");
      WardHome wardHome = new WardHome();
      wardHome.wardManageHomePage();
    }
  }
}
