package DatabaseLayer.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

public class ViewReportsDao {
	String docId;
	Connection connection = null;
	IDatabaseConnection databaseConnection;
	IDatabaseConnectionFactory databaseConnectionFactory;
	public ViewReportsDao()
	{
		databaseConnectionFactory = new DatabaseConnectionFactory();
		databaseConnection = databaseConnectionFactory.getDatabaseConnection();
	}
	public ArrayList<Reports> getAllReports(String docId) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ArrayList<Reports> reportlist=new ArrayList<Reports>();
		connection = databaseConnection.openDBConnection();
		String query="Select * from reports where doc_id= ? Limit 1";
		PreparedStatement statement;
		try
		{
			statement=connection.prepareStatement(query);
			statement.setString(1, docId);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				Reports r=new Reports();
				r.setReportId(rs.getInt("rep_id"));
				r.setDoctorId(rs.getInt("doc_id"));
				r.setPatientId(rs.getString("patient_id"));
				r.setDiagnosisName(rs.getString("diagnosis_name"));
				r.setDate(rs.getString("date"));
				r.setTestResult(rs.getString("test_result"));
				r.setTestType(rs.getString("test_type"));
				reportlist.add(r);
			}
			return reportlist;
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			databaseConnection.closeDBConnection();
		}
		return new ArrayList<>();

	}
	public ArrayList<Reports> getPatientReports(String docId,String patientId) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ArrayList<Reports> reportlist=new ArrayList<Reports>();
		connection = databaseConnection.openDBConnection();
		String query="Select * from reports where doc_id= ? and patient_id=? Limit 1";
		PreparedStatement statement;
		try
		{
			statement=connection.prepareStatement(query);
			statement.setString(1, docId);
			statement.setString(2, patientId);
			ResultSet rs=statement.executeQuery();
			while(rs.next())
			{
				Reports r=new Reports();
				r.setReportId(rs.getInt("rep_id"));
				r.setDoctorId(rs.getInt("doc_id"));
				r.setPatientId(rs.getString("patient_id"));
				r.setDiagnosisName(rs.getString("diagnosis_name"));
				r.setDate(rs.getString("date"));
				r.setTestResult(rs.getString("test_result"));
				r.setTestType(rs.getString("test_type"));
				reportlist.add(r);
			}
			return reportlist;
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} finally {
			databaseConnection.closeDBConnection();
		}
		return new ArrayList<>();

	}
}
