package DatabaseLayer.Dao;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewPatientReportsDAO {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;
    ResultSet resultSet=null;

    public ViewPatientReportsDAO() {

//           this.databaseConnection = DatabaseConnection.createInstance();
//           this.connection = databaseConnection.openDBConnection();
    }

    public ResultSet fetchLabReports(String patientID) {

        try{
            String queryToFetchReports = "SELECT rep_id,diagnosis_name,CONCAT('Dr.',dr.first_name,' ',dr.last_name) as Referred_By,date,test_type,test_result \n" +
                    "FROM lab_reports lr join doctors dr on dr.id=lr.doc_id \n" +
                    "WHERE lr.patient_id='" + patientID + "';";
            statement = connection.createStatement();
            resultSet= statement.executeQuery(queryToFetchReports);
        } catch (SQLException e) {
            System.err.print("SQL ERROR");
        }finally {
            databaseConnection.closeDBConnection();
        }
        return resultSet;
    }

}
