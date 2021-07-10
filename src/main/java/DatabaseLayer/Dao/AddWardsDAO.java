/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Wards;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddWardsDAO {
    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* The details of the ward can be added
     * The details are added by using SQL query
     */
    public static int addWard(Wards ward){
        int status = 0;
        try {

            String insertQuery = "INSERT INTO  wards VALUES ('"+ ward.getWardId() +"','"+ ward.getWardType() +"', '"+
                    ward.getWardName() +"','"+ ward.getLocation() +"', '"+ ward.getTotalBeds() +"','"+
                    ward.getBedType() +"')" ;

            //if successful status returns 1
            status = statement.executeUpdate(insertQuery);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return status;


    }
}
