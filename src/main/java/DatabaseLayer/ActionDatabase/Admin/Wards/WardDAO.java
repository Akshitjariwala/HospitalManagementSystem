package DatabaseLayer.ActionDatabase.Admin.Wards;

import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WardDAO implements IWardDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public WardDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }

  @Override
  public Ward getWard(int wardId) {
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM wards WHERE ward_id = ? LIMIT 1";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setInt(1, wardId);
      ResultSet rs = statement.executeQuery();
      Ward ward = new Ward();
      if (rs.next()) {
        ward.setWardId(wardId);
        ward.setWardName(rs.getString("name"));
        ward.setWardType(rs.getString("ward_type"));
        ward.setLocation(rs.getString("location"));
        ward.setBedType(rs.getString("bed_type"));
        ward.setTotalBeds(rs.getInt("total_beds"));
      }
      return ward;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return null;
  }


  @Override
  public List<Ward> getWardsList() {
    ArrayList<Ward> wards = new ArrayList<>();
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM wards";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);

      ResultSet rs = statement.executeQuery();

      while (rs.next()) {
        Ward ward = new Ward();
        ward.setWardId(rs.getInt("ward_id"));
        ward.setWardName(rs.getString("name"));
        ward.setWardType(rs.getString("ward_type"));
        ward.setLocation(rs.getString("location"));
        ward.setBedType(rs.getString("bed_type"));
        ward.setTotalBeds(rs.getInt("total_beds"));
        wards.add(ward);
      }
      return wards;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return new ArrayList<>();
  }


  @Override
  public int addWard(Ward ward) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    int status = 0;
    try {

      String insertQuery = "INSERT INTO  wards VALUES ('" + ward.getWardId() + "','" + ward.getWardType() + "', '" +
              ward.getWardName() + "','" + ward.getLocation() + "', '" + ward.getTotalBeds() + "','" +
              ward.getBedType() + "')";

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

  @Override
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
}
