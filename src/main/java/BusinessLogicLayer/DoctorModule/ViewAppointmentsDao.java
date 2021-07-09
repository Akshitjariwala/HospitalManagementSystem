package BusinessLogicLayer.DoctorModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogicLayer.AdminModule.Appointment;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

public class ViewAppointmentsDao {
	Connection connection = null;
	IDatabaseConnection databaseConnection;
	IDatabaseConnectionFactory databaseConnectionFactory;

	public ViewAppointmentsDao() {
		databaseConnectionFactory = new DatabaseConnectionFactory();
		databaseConnection = databaseConnectionFactory.getDatabaseConnection();
	}

	public ArrayList<Appointment> getAppointmentList(String query) {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointments = new ArrayList<>();
		connection = databaseConnection.openDBConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Appointment appointment = new Appointment();
				appointment.setAppointmentId(rs.getInt("app_id"));
				appointment.setPatientId(rs.getString("patient_id"));
				appointment.setDate(rs.getString("date"));
				appointment.setPreferredSlot(rs.getString("preferred_slot"));
				appointment.setTypeOfAppointment(rs.getString("type_of_appo"));
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
}


