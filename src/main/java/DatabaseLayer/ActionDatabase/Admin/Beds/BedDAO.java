package DatabaseLayer.ActionDatabase.Admin.Beds;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.ActionDatabase.Admin.Wards.WardDAO;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BedDAO implements IBedDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public BedDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
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
      WardDAO wardDAO = new WardDAO();
      if (rs.next()) {
        bed.setWard(wardDAO.getWard(rs.getInt("ward_id")));
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
  public List<Bed> getWardBeds(int wardId) {
    connection = databaseConnection.openDBConnection();
    String query = "SELECT * FROM beds WHERE ward_id = ? AND isOccupied = 1";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      statement.setInt(1, wardId);
      ResultSet rs = statement.executeQuery();
      ArrayList<Bed> beds = new ArrayList<>();
      WardDAO wardDAO = new WardDAO();
      while (rs.next()) {
        Bed bed = new Bed();
        bed.setWard(wardDAO.getWard(wardId));
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
  public List<PatientBed> getPatientBed(int wardId) {
    List<Bed> beds = getWardBeds(wardId);
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

  @Override
  public List<BedCounts> showCurrentAvailableBeds() {
    List<BedCounts> bd = new ArrayList<>();
    connection = databaseConnection.openDBConnection();
    String query = "select count(bed_id) as bedcounts,ward_id,bed_type from beds where isOccupied=0 group by ward_id";
    PreparedStatement statement;
    try {
      statement = connection.prepareStatement(query);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        BedCounts bedcount = new BedCounts();
        bedcount.setNumberOfBeds(rs.getInt("bedcounts"));
        Ward w = new Ward();
        w.setWardId(rs.getInt("ward_id"));
        bedcount.setWard(w);
        bedcount.setBedType(rs.getString("bed_type"));
        bd.add(bedcount);

      }
      return bd;
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } finally {
      databaseConnection.closeDBConnection();
    }
    return new ArrayList<>();
  }
}
