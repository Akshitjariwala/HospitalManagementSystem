package BusinessLogicLayer.AdminModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
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
    return null;
  }

  public boolean updateAppointmentStatus(int appId) {
    return false;
  }
}
