package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateWardsDAO {

  private Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public UpdateWardsDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  /* Once the details are received for which update is required
   * The details are updated using SQL query
   */
  public void updateWard(String str, int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);
    try {
      String updateQuery = "UPDATE wards set" + "\t" + str + "\t" + "where ward_id = " + id;
      statement.executeUpdate(updateQuery);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
  }

  /* The details of the ward for which the details have to be updated the id is passed
   * The details are fetched by using SQL query
   */
  public Ward getWardDetails(int id) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Ward ward = new Ward();
    try {
      String query1 = "SELECT * from wards where ward_id = '" + id + "' ";
      ResultSet rs = statement.executeQuery(query1);
      while (rs.next()) {
        ward.setWardId(rs.getInt("ward_id"));
        ward.setWardType(rs.getString("ward_type"));
        ward.setWardName(rs.getString("name"));
        ward.setLocation(rs.getString("location"));
        ward.setTotalBeds(rs.getInt("total_beds"));
        ward.setBedType(rs.getString("bed_type"));

      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return ward;
  }
}
