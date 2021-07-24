package DatabaseLayer.Dao;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public class ViewPatientReportsDAO {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement = null;

}
