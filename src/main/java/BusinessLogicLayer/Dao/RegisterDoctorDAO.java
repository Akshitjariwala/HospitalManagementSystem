/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class RegisterDoctorDAO {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;
    public static LocalDate todayDate = LocalDate.now();

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /* The details of the doctor can be added
     * The details are added by using SQL query
     */
    public static byte addDoctor(Doctor doct) {


        return 0;
    }



    /* Once the particular detail which has to be fetched is given should come here
     * The details are updated using SQL query
     */
    public static void updateDoctor(String s, int id) throws SQLException, ClassNotFoundException {

    }
}
