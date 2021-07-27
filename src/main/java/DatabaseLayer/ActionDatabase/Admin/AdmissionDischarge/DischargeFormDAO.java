package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;
import java.sql.*;

public class DischargeFormDAO implements IDischargeFormDAO {
    
    Connection connection = null;
    IDatabaseConnection databaseConnection;
    IDatabaseConnectionFactory databaseConnectionFactory;
    
    public DischargeFormDAO() {
        databaseConnectionFactory = new DatabaseConnectionFactory();
        databaseConnection = databaseConnectionFactory.getDatabaseConnection();
    }

    @Override
    public boolean dischargePatient(Admission admission) {
        connection = databaseConnection.openDBConnection();
        Statement statement = databaseConnection.createStatement(connection);
        
        int result;
        int response;
        boolean output = false;
        Date date = admission.getDischargeDate();
        String dischargeSQL = "UPDATE admission SET date_of_discharge = ? , comments = ? WHERE admissionID = ?";
        String updateBed = "UPDATE beds SET isOccupied = 0 WHERE bed_id = " + admission.getBedID();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(dischargeSQL);
            ps.setDate(1, date);
            ps.setString(2, admission.getDischargeComment());
            ps.setInt(3, admission.getAdmissionID());
    
            result = ps.executeUpdate();
    
            if (result == 1) {
                response = statement.executeUpdate(updateBed);
                if (response == 1) {
                    output = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        databaseConnection.closeDBConnection();
        
        return output;
    }
}
