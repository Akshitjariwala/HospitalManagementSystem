package DatabaseLayer.Dao;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientLoginDAO {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String getLoginCredentials(String userID){
        ResultSet resultSet=null;
        String providedPassword="";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT password FROM login_cred WHERE userid='" + userID + "';");
            while (resultSet.next()) {
                providedPassword = resultSet.getString(1);
            }
        }catch (SQLException e){
            System.out.println("SQL ERROR");
        }

        return providedPassword;
    }

    public String getPatientName(String userID) {
        ResultSet resultSet = null;
        String patientName="";
        try {
            statement = connection.createStatement();
            String queryToGetPatientName = "SELECT CONCAT(first_name,' ',last_name) FROM patients where patient_id='" + userID + "';";
             resultSet = statement.executeQuery(queryToGetPatientName);
            while (resultSet.next()) {
                patientName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            System.out.println("SQL ERROR");
        }

        return patientName;
    }
}
