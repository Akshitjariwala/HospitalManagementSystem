
package DatabaseLayer.ActionDatabase.Patient.BookAppointments;

import BusinessLogicLayer.BeanClasses.PatientAppointmentWithDoctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookAppointmentsDAO implements IBookAppointmentsDAO {

  private Connection connection = null;
  private IDatabaseConnection databaseConnection;
  private IDatabaseConnectionFactory databaseConnectionFactory;
  private Statement statement = null;

  public BookAppointmentsDAO() {

    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public String getPatientName(String patientid) {

    ResultSet resultSet = null;
    String patientName = "";
    try {
      connection = databaseConnection.openDBConnection();
      statement = connection.createStatement();
      String queryToGetPatientName = "SELECT concat(first_name,' ',last_name) FROM patients where patient_id='" + patientid + "';";
      resultSet = statement.executeQuery(queryToGetPatientName);
      while (resultSet.next()) {
        patientName = resultSet.getString(1);
      }
    } catch (SQLException e) {
      System.err.println("SQL ERROR");
    } finally {
      databaseConnection.closeDBConnection();
    }
    return patientName;
  }

  public ResultSet fetchDoctorList() {

    ResultSet resultSet = null;
    try {

      connection = databaseConnection.openDBConnection();
      String fetchingDoctorDetails = "SELECT concat('Dr.',first_name,' ', last_name) as doctor_name,specialization,experience_years FROM doctors;";
      statement = connection.createStatement();
      resultSet = statement.executeQuery(fetchingDoctorDetails);
    } catch (SQLException SQL) {
      System.err.println("SQL ERROR");
    }
    return resultSet;
  }

  public boolean saveAppointment(String patient, String doctor, PatientAppointmentWithDoctor appointmentWithDoctor) {
    int doctor_id = 0;
    ResultSet resultSet = null;
    String appointmentStatus = "PENDING";
    try {
      connection = databaseConnection.openDBConnection();
      statement = connection.createStatement();
      String querytoFindID = "Select dr.id from doctors dr " +
              " where concat('Dr.',dr.first_name,' ',dr.last_name)='" + doctor + "';";

      resultSet = statement.executeQuery(querytoFindID);

      while (resultSet.next()) {
        doctor_id = resultSet.getInt(1);
      }

      String queryToSaveAppointment = "INSERT INTO appointments (patient_id, doc_id, appointment_date, preferred_slot, type_of_appo, appointment_status) \n" +
              "VALUES ('" + patient + "','" + doctor_id + "','" + appointmentWithDoctor.getAppointmentDate() + "','" + appointmentWithDoctor.getTimeSlot() + "','" + appointmentWithDoctor.getTypeOfAppointment() + "','" + appointmentStatus + "');";

      String queryToCheckEntry = "SELECT * from patients_doctors_mapping WHERE patient_id='" + patient + "' " +
              "AND doc_id='" + doctor_id + "';";

      ResultSet tempResultSet = statement.executeQuery(queryToCheckEntry);
      if (!tempResultSet.next()) {
        String queryToMapPatientWithDoctor = "INSERT INTO patients_doctors_mapping (patient_id, doc_id) \n" +
                "VALUES ('" + patient + "','" + doctor_id + "');";
        statement.addBatch(queryToMapPatientWithDoctor);
      }

      statement.addBatch(queryToSaveAppointment);
      int[] tempResult = statement.executeBatch();
    } catch (SQLException e) {
      System.err.println("New APPOINTMENT FAILED TO SAVE");
      e.printStackTrace();
      return false;
    } finally {
      databaseConnection.closeDBConnection();
    }
    return true;
  }
}
