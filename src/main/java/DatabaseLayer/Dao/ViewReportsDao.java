package DatabaseLayer.Dao;

import java.sql.Connection;
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
		
		
		
		return null;
	}

}
