package BusinessLogicLayer.DoctorModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogicLayer.PatientModule.Patient;
import BusinessLogicLayer.WardModule.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;


public class ViewPatientsDao {

	Connection connection = null;
	IDatabaseConnection databaseConnection;
	IDatabaseConnectionFactory databaseConnectionFactory;

	public ViewPatientsDao()
	{
		databaseConnectionFactory = new DatabaseConnectionFactory();
		databaseConnection = databaseConnectionFactory.getDatabaseConnection();
	}

	public ArrayList<Patient> getPatients(String docId) {
		// TODO Auto-generated method stub
		ArrayList<String> patientidlist=getPatientIds(docId);
		ArrayList<Patient> patientlist=new ArrayList<Patient>();
		connection = databaseConnection.openDBConnection();
		String query="Select * from patients where patient_id= ? Limit 1";
		for(String id:patientidlist)
		{
			PreparedStatement statement;
			try
			{
				statement=connection.prepareStatement(query);
				statement.setString(1, id);
				ResultSet rs=statement.executeQuery();
				while(rs.next())
				{
					Patient p=new Patient();
					//Kishan uncomment this after fixing patientid setter
//					p.setUserID(rs.getString("patient_id"));
//					p.setAddress(rs.getString("address"));
//					p.setCityName(rs.getString("city"));
//					p.setEmaiID()rs.getString("email"));
//					p.setEmergencyContactName(rs.getString("emg_contact_name"));
//					p.setEmergencyContactNumber(rs.getString("emg_contact_phone"));
//					p.setFirstName(rs.getString("first_name"));
//					p.setLastName(rs.getString("last_name"));
//					p.setMiddleName(rs.getString("middle_name"));
//					p.setPhoneNumber(rs.getString("phone_number"));
//					p.setStateName(rs.getString("state"));
					patientlist.add(p);				
					
				}
				return patientlist;

			}
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} finally {
				databaseConnection.closeDBConnection();
			}
		}


		return null;
	}
	private ArrayList<String> getPatientIds(String docId)
	{
		ArrayList<String> patientIdlist=new ArrayList<String>();
		String query = "SELECT * FROM patients_doctors_mapping where doc_id=? Limit 1";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, docId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				patientIdlist.add(rs.getString("patient_id"));	        
			}
			return patientIdlist;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			databaseConnection.closeDBConnection();
		}
		return null;
	}


}