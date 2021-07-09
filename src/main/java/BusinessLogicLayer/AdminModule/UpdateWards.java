/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Doctor;
import BusinessLogicLayer.BeanClasses.Wards;
import DatabaseLayer.Dao.RegisterDoctorDAO;
import DatabaseLayer.Dao.UpdateWardsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateWards {

    private static String updateStr ="";

    public static void updateWards() throws SQLException, ClassNotFoundException {
        System.out.println("Enter the id of the ward that has to be updated");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Wards ward = UpdateWardsDAO.getWardDetails(id);
        int wardId = ward.getWardId();

        System.out.println("===========The details of the ward"+" "+ wardId+"are==================");
        System.out.println("1.  Ward Type :" + ward.getWardType());
        System.out.println("2.  Ward Name :" + ward.getWardName());
        System.out.println("3.  Ward Location :" + ward.getLocation());
        System.out.println("4.  Total Beds :"+ ward.getTotalBeds());
        System.out.println("5.  Bed Type :" + ward.getBedType() );
        System.out.println("6. Exit");


    }
}
