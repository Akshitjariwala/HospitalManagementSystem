package BusinessLogicLayer.AdminModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppointmentDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public AppointmentDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public ArrayList<Appointment> getAppointmentList() {
    ArrayList<Appointment> appointments = new ArrayList<>();
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM appointments";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(rs.getInt("app_id"));
        appointment.setPatientId(rs.getString("patient_id"));
        appointment.setDoctorId(rs.getString("doc_id"));
        appointment.setDate(rs.getString("date"));
        appointment.setPreferredSlot(rs.getString("preferred_slot"));
        appointment.setTypeOfAppointment(rs.getString("type_of_appo"));
        appointment.setAppointmentStatus(rs.getString("appointment_status"));
        appointments.add(appointment);
      }
      return appointments;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return new ArrayList<>();
  }

  public boolean updateAppointmentStatus(int appId, String newStatus) {
    connection = databaseConnection.openDBConnection();
    String query = "UPDATE appointments SET appointment_status = ? WHERE app_id = ?";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setString(1, newStatus);
      statement.setInt(2, appId);

      int rowAffected = statement.executeUpdate();
      return rowAffected > 0;

    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return false;
  }
}
