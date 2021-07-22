/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddReportsDAO {
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

    public static int addReport(Reports report){
        int status = 0;
        try {

            String insertQuery = "INSERT INTO  lab_reports VALUES ('"+ report.getReportId() +"','"+ report.getDoctorId() +"', '"+
                    report.getPatientId() +"','"+ report.getDiagnosisName() +"', '"+ report.getDate() +"','"+
                    report.getTestResult() +"','"+ report.getTestType() +"')" ;

            //if successful status returns 1
            status = statement.executeUpdate(insertQuery);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return status;


    }

    /* To add the reports the doctor id is necessary
     * The id should be existing in the doctors table
     * It is matched with the help of query
     */
    public static int checkDoctorId(int id){
       int count=0;
        try {
            String checkQuery = "SELECT id FROM doctors WHERE id = '"+id+"'";
             ResultSet rs = statement.executeQuery(checkQuery);
            while (rs.next()){
                count=rs.getInt("id");
            }

            System.out.println(count);

        }catch (Exception e){
            System.out.println(e);
        }
        return count;
    }

    /* To add the reports the patient id is necessary
     * The id should be existing in the patient table
     * It is matched with the help of query
     */
    public static String checkPatientId(String id){
        String str=null;
        try {
            String checkQuery = "SELECT patient_id FROM patients WHERE patient_id = '"+id+"'";
            ResultSet rs = statement.executeQuery(checkQuery);
            while (rs.next()){
                str=rs.getString("patient_id");
            }
            System.out.println(str);
        }catch (Exception e){
            System.out.println(e);
        }
        return str;
    }
}
