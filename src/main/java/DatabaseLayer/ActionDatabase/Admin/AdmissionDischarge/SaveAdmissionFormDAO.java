package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.*;
import java.time.LocalDate;

public class SaveAdmissionFormDAO implements IAdmissionFormDAO {
    
    Connection connection = null;
    IDatabaseConnection databaseConnection;
    IDatabaseConnectionFactory databaseConnectionFactory;
    public static LocalDate todayDate = LocalDate.now();
    
    public SaveAdmissionFormDAO() {
        databaseConnectionFactory = new DatabaseConnectionFactory();
        databaseConnection = databaseConnectionFactory.getDatabaseConnection();
    }
    
    @Override
    public int saveAdmissionForm(Admission admission) {
        connection = databaseConnection.openDBConnection();
        Statement statement = databaseConnection.createStatement(connection);
        
        int result=0;
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement("INSERT INTO admission(patient_id,date_of_admission,admission_type,ward_id,bed_id,doc_id,disease_code) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, admission.getPatientID());
            ps.setDate(2, Date.valueOf(todayDate));
            ps.setInt(3, admission.getAdmissionType());
            ps.setInt(4, admission.getWardID());
            ps.setInt(5, admission.getBedID());
            ps.setInt(6, admission.getDoctorID());
            ps.setInt(7, admission.getDiseaseID());
            result = ps.executeUpdate();
    
            if (result == 1) {
                statement.executeUpdate("UPDATE beds SET isOccupied = 1 WHERE bed_id = " + admission.getBedID());
            }
            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        databaseConnection.closeDBConnection();
        
        return result;
    }
    
    @Override
    public int updateAdmissionForm(Admission admission){
        connection = databaseConnection.openDBConnection();
        connection = databaseConnection.openDBConnection();
        int result=0;
        PreparedStatement ps;
        
        String updateSQL = "UPDATE admission SET patient_id = ? , admission_type = ? , ward_id = ? , bed_id = ? , doc_id = ? , disease_code = ? WHERE admissionID = ?";
        
        try {
            ps = connection.prepareStatement(updateSQL);
            ps.setString(1, admission.getPatientID());
            ps.setInt(2, admission.getAdmissionType());
            ps.setInt(3, admission.getWardID());
            ps.setInt(4, admission.getBedID());
            ps.setInt(5, admission.getDoctorID());
            ps.setInt(6, admission.getDiseaseID());
            ps.setInt(7, admission.getAdmissionID());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        databaseConnection.closeDBConnection();
        
        return result;
    }
}
