package BusinessLogicLayer.WardModule;

import BusinessLogicLayer.User.Patient;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class WardDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public WardDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public Ward getWard(int wardId) {
    return null;
  }

  public ArrayList<Bed> getWardBeds(int wardId) {
    return null;
  }

  public ArrayList<PatientBed> getPatientBed(int wardId) {
    return null;
  }
}
