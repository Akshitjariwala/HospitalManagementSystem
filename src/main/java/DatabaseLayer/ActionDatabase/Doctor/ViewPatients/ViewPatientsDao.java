package DatabaseLayer.ActionDatabase.Doctor.ViewPatients;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

public class ViewPatientsDao implements IViewPatientsDao {

	private Connection connection = null;
	IDatabaseConnection databaseConnection;
	IDatabaseConnectionFactory databaseConnectionFactory;

	public ViewPatientsDao() {
		databaseConnectionFactory = new DatabaseConnectionFactory();
		databaseConnection = databaseConnectionFactory.getDatabaseConnection();
	}

	public List<Patient> getPatients(int docId) {
		List<String> patientidlist = getPatientIds(docId);
		if (patientidlist != null) {
			ArrayList<Patient> patientlist = new ArrayList<>();
			connection = databaseConnection.openDBConnection();
			String query = "Select * from patients where patient_id= ? Limit 1";

			PreparedStatement statement;
			try {
				for (String id : patientidlist) {
					statement = connection.prepareStatement(query);
					statement.setString(1, id);
					ResultSet rs = statement.executeQuery();
					while (rs.next()) {
						Patient p = new Patient();
						p.setUserID(rs.getString("patient_id"));
						p.setAddress(rs.getString("address"));
						p.setCityName(rs.getString("city"));
						p.setEmaiID(rs.getString("email"));
						p.setEmergencyContactName(rs.getString("emg_contact_name"));
						p.setEmergencyContactNumber(rs.getString("emg_contact_phone"));
						p.setFirstName(rs.getString("first_name"));
						p.setLastName(rs.getString("last_name"));
						p.setMiddleName(rs.getString("middle_name"));
						p.setPhoneNumber(rs.getString("phone_number"));
						p.setStateName(rs.getString("state"));
						patientlist.add(p);

					}

				} 
			}catch (SQLException sqlException) {
					sqlException.printStackTrace();
				} finally {
					databaseConnection.closeDBConnection();
				}
			return patientlist;
			}
		
		return new ArrayList<>();
	}

	private List<String> getPatientIds(int docId) {
		connection = databaseConnection.openDBConnection();
		ArrayList<String> patientIdlist = new ArrayList<>();
		String query = "SELECT * FROM patients_doctors_mapping where doc_id=?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setInt(1, docId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				patientIdlist.add(rs.getString("patient_id"));
			}
			Set<String> patientSet=new HashSet<String>(patientIdlist);
			ArrayList<String> patientList=new ArrayList<String>(patientSet);
			return patientList;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			databaseConnection.closeDBConnection();
		}
		return new ArrayList<>();
	}
}
