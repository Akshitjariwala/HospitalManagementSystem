package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorLoginDAO {
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

    public static int checkDoctorLogin(String id, String password){
        Doctor doc = new Doctor();
        String count = null;
        String str = null;

        int status =0;
        try{
            String CheckLoginQuery = "SELECT doc_id, password, first_name, last_name FROM doctors WHERE doc_id = '"+id+"' " +
                    "AND password = '"+password+"'";
            ResultSet rs = statement.executeQuery(CheckLoginQuery);
            while (rs.next()){
                count=rs.getString("doc_id");
                str = rs.getString("password");

            }
            System.out.println(count);
            System.out.println(str);
            if(count !=null && str != null){
                status = 1;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return status;
    }
}
