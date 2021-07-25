package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.*;

public class LoginDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public LoginDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  public String checkUserExist(String userName, String password) {
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM login_cred WHERE  userid = ? AND password = ? LIMIT 1";
    PreparedStatement statement;
    String userType = null;
    try {
      statement = connection.prepareStatement(query);
      statement.setString(1, userName);
      statement.setString(2, password);
      ResultSet rs = statement.executeQuery();
      if (rs.next()) {
        userType = rs.getString("user_type");
      }
      return userType;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return userType;
  }
}
