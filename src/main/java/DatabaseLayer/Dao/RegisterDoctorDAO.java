/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class RegisterDoctorDAO {

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

    /* The details of the doctor can be added
     * The details are added by using SQL query
     */
    public static int addDoctor(Doctor doct){

        int status = 0;
        try {

            String insertQuery = "INSERT INTO  doctors VALUES ('"+ doct.getId() +"','"+ doct.getMedicalLicenseId() +"', '"+ doct.getPassword() +"','"+
                    doct.getLastName() +"', '"+ doct.getFirstName() +"','"+ doct.getMiddleName() +"', " +
                    "'"+ doct.getEmailId() +"', '"+ doct.getPhoneNumber() +"' ," +
                    " '"+ doct.getAddress() +"' ,'"+ doct.getCity() +"' , " +
                    "'"+ doct.getState() +"', '"+ doct.getExperience() +"','"+ doct.getSpecialization() +"', " +
                    "'"+ doct.getDepartment() +"')" ;

            status = statement.executeUpdate(insertQuery);  //if successful status should return 1
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    /* The details of the doctor for which the details have to be updated should an id is passed
     * The details are fetched by using SQL query
     */
    public static Doctor getDoctor(int id){

        Doctor doct = new Doctor();
        try {

            String query1 = "SELECT * from doctors where doc_id = '" + id + "' ";
            ResultSet rs = statement.executeQuery(query1);
            while(rs.next()) {
                doct.setId(rs.getInt("id"));
                doct.setMedicalLicenseId(rs.getString("doc_id"));
                doct.setPassword(rs.getString("password"));
                doct.setLastName(rs.getString("last_name"));
                doct.setFirstName(rs.getString("first_name"));
                doct.setMiddleName(rs.getString("middle_name"));
                doct.setEmailId(rs.getString("email"));
                doct.setPhoneNumber(rs.getString("phone_number"));
                doct.setAddress(rs.getString("address"));
                doct.setCity(rs.getString("city"));
                doct.setState(rs.getString("state"));
                doct.setExperience(rs.getString("experience_years"));
                doct.setSpecialization(rs.getString("specialization"));
                doct.setDepartment(rs.getString("department"));

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return doct;
    }



    /* Once the particular detail which has to be fetched is given should come here
     * The details are updated using SQL query
     */
    public static void updateDoctor(String s, int id) throws SQLException, ClassNotFoundException {
        System.out.println("in update query");
        try {

            String updateQuery = "UPDATE doctors set" + "\t" + s + "\t"+ "where id = " + id ;
            System.out.println(updateQuery);
            statement.executeUpdate(updateQuery);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
