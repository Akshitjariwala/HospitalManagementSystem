package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import BusinessLogicLayer.PatientModule.PatientRegistration;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class PatientRegistrationDAO  {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;
    private ResultSet resultSet = null;

    public int savePatientDetails(Patient patient) {
       int status=0;
        try  {
            statement = connection.createStatement();
            String query1 = "INSERT INTO patients (patient_id, password, last_name, first_name, middle_name, email, phone_number, address, city, state, type_of_patient, emg_contact_name, emg_contact_phone)" +
                    "VALUES ('" + patient.getUserID() + "','" + patient.getPassword() + "','" + patient.getLastName() + "','" + patient.getFirstName() + "','" + patient.getMiddleName() + "','" + patient.getEmaiID() + "','" + patient.getPhoneNumber() + "','" + patient.getAddress() + "','" + patient.getCityName() + "','" + patient.getStateName() + "','Patient','" + patient.getEmergencyContactName() + "','" + patient.getEmergencyContactNumber() + "');";
            //  statement.executeUpdate(query1);
            String query2 = "INSERT INTO login_cred VALUES ('" + patient.getUserID() + "','" + patient.getPassword() + "','Patient');";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            status=1;
        } catch (BatchUpdateException exception){
            System.err.println("***** Username already exists *****\n");
            status=-1;
        } catch (SQLException E) {
            System.err.println("***** SQL ERROR *****");
            status=0;
        }
        return status;
    }
}
