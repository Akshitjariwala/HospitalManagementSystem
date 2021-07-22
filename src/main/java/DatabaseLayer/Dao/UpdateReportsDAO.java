package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateReportsDAO {

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

    /* Once the details are received for which update is required
     * The details are updated using SQL query
     */
    public static void updateReport(String str, int id) throws SQLException, ClassNotFoundException {
        try {
            String updateQuery = "UPDATE lab_reports set" + "\t" + str + "\t"+ "where rep_id = " + id ;
            System.out.println(updateQuery);
            statement.executeUpdate(updateQuery);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Reports getReportsDetails(int id){
        Reports report = new Reports();

        try{
            String selectQuery = "SELECT * from lab_reports where rep_id = '" + id + "' ";
            ResultSet rs = statement.executeQuery(selectQuery);
            while(rs.next()) {
                report.setReportId(rs.getInt("rep_id"));
                report.setDoctorId(rs.getInt("doc_id"));
                report.setPatientId(rs.getString("patient_id"));
                report.setDiagnosisName(rs.getString("diagnosis_name"));
                report.setDate(rs.getString("date"));
                report.setTestResult(rs.getString("test_result"));
                report.setTestType(rs.getString("test_type"));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return report;
    }

}
