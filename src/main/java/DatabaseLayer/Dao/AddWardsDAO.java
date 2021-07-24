/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.Statement;

public class AddWardsDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public AddWardsDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  /* The details of the ward can be added
   * The details are added by using SQL query
   */
  public int addWard(Ward ward) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    int status = 0;
    try {

      String insertQuery = "INSERT INTO  wards VALUES ('" + ward.getWardId() + "','" + ward.getWardType() + "', '" +
              ward.getWardName() + "','" + ward.getLocation() + "', '" + ward.getTotalBeds() + "','" +
              ward.getBedType() + "')";

      //if successful status returns 1
      if (statement != null) {
        status = statement.executeUpdate(insertQuery);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return status;
  }
}
