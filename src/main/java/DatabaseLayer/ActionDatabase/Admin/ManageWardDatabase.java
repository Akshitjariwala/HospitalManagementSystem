package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.WardModule.Bed;
import BusinessLogicLayer.WardModule.PatientBed;
import BusinessLogicLayer.WardModule.Ward;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageWardDatabase implements IManageWardDatabase {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public ManageWardDatabase() {
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
  public Bed getBed(int bedId) {
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM beds WHERE bed_id = ? LIMIT 1";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setInt(1, bedId);
      ResultSet rs = statement.executeQuery();
      Bed bed = new Bed();
      if (rs.next()) {
        bed.setWard(getWard(rs.getInt("ward_id")));
        bed.setBedId(rs.getInt("bed_id"));
        bed.setBedType(rs.getString("bed_type"));
        bed.setBedCode(rs.getString("bed_code"));
        bed.setOccupied(rs.getBoolean("isOccupied"));
      }
      return bed;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return null;
  }

  @Override
  public ArrayList<Ward> getWardsList() {
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
  public ArrayList<Bed> getWardBeds(int wardId) {
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM beds WHERE ward_id = ? AND isOccupied = 1";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setInt(1, wardId);
      ResultSet rs = statement.executeQuery();
      ArrayList<Bed> beds = new ArrayList<>();
      while (rs.next()) {
        Bed bed = new Bed();
        bed.setWard(getWard(wardId));
        bed.setOccupied(true);
        bed.setBedId(rs.getInt("bed_id"));
        bed.setBedCode(rs.getString("bed_code"));
        bed.setBedType(rs.getString("bed_type"));
        beds.add(bed);
      }
      return beds;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return new ArrayList<>();
  }

  @Override
  public ArrayList<PatientBed> getPatientBed(int wardId) {
    ArrayList<Bed> beds = getWardBeds(wardId);
    List<Integer> bedIds = new ArrayList<>();
    for (Bed b : beds) {
      bedIds.add(b.getBedId());
    }
    connection = databaseConnection.openDBConnection();

    String query = "SELECT patient_id, last_name, first_name, bed_id FROM patients WHERE bed_id IS NOT NULL AND bed_id IN (SELECT beds.bed_id FROM beds WHERE isOccupied = 1 AND ward_id = ?)";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setInt(1, wardId);
      ResultSet rs = statement.executeQuery();
      ArrayList<PatientBed> patientBeds = new ArrayList<>();
      while (rs.next()) {
        PatientBed patientBed = new PatientBed();
        patientBed.setBed(getBed(rs.getInt("bed_id")));
        patientBed.setPatientName(rs.getString("first_name") + " " + rs.getString("last_name"));
        patientBed.setPatientId(rs.getString("patient_id"));
        patientBeds.add(patientBed);
      }
      return patientBeds;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return new ArrayList<>();
  }
}
