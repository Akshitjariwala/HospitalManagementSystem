package DatabaseLayer.DatabaseConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection {

  private static final String CONFIG_FILENAME = "config.properties";
  private static final String DRIVER_CLASSNAME = "db.driverClassName";
  private static final String DB_URL = "db.url";
  private static final String DB_USERNAME = "db.username";
  private static final String DB_PASSWORD = "db.password";

  private static DatabaseConnection databaseConnection;
  private static Connection connection;
  private static String url;
  private static String dbUsername;
  private static String dbPassword;

  private DatabaseConnection() {
    InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME);
    Properties prop = new Properties();
    try {
      if (inputStream != null) {
        prop.load(inputStream);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    String driverClassname = prop.getProperty(DRIVER_CLASSNAME);
    url = prop.getProperty(DB_URL);
    dbUsername = prop.getProperty(DB_USERNAME);
    dbPassword = prop.getProperty(DB_PASSWORD);

    try {
      Class.forName(driverClassname);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (Exception exception) {
      exception.getStackTrace();
    }
  }

  public static DatabaseConnection createInstance() {
    if (databaseConnection == null) {
      databaseConnection = new DatabaseConnection();
    }
    return databaseConnection;
  }

  @Override
  public Connection openDBConnection() {
    try {
      connection = DriverManager.getConnection(url, dbUsername, dbPassword);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  @Override
  public void closeDBConnection() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Statement createStatement(Connection connection) {
    Statement statement = null;
    try {
      statement = connection.createStatement();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
    return statement;
  }
}
