package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.*;

public class PatientRegistrationDAO  {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;
    private ResultSet resultSet = null;

    public PatientRegistrationDAO()  {

//        this.databaseConnection = DatabaseConnection.createInstance();
//        this.connection = databaseConnection.openDBConnection();
    }

    public int savePatientDetails(Patient patient) {
       int status=0;
        try  {
            statement = connection.createStatement();
            String query1 = "INSERT INTO patients (patient_id, password, last_name, first_name, middle_name, email, phone_number, address, city, state, type_of_patient, emg_contact_name, emg_contact_phone)" +
                    "VALUES ('" + patient.getUserID() + "','" + patient.getPassword() + "','" + patient.getLastName() + "','" + patient.getFirstName() + "','" + patient.getMiddleName() + "','" + patient.getEmaiID() + "','" + patient.getPhoneNumber() + "','" + patient.getAddress() + "','" + patient.getCityName() + "','" + patient.getStateName() + "','Patient','" + patient.getEmergencyContactName() + "','" + patient.getEmergencyContactNumber() + "');";
            String query2 = "INSERT INTO login_cred VALUES ('" + patient.getUserID() + "','" + patient.getPassword() + "','Patient');";
            statement.addBatch(query1);
            statement.addBatch(query2);
            statement.executeBatch();
            status=1;
        } catch (BatchUpdateException exception){
            status=-1;
        } catch (SQLException E) {
            System.err.println("***** SQL ERROR *****");
            status=0;
        }finally {
            databaseConnection.closeDBConnection();
        }
        return status;
    }
}
