package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.DatabaseConnection.DatabaseConnectionFactory;
import DatabaseLayer.DatabaseConnection.IDatabaseConnection;
import DatabaseLayer.DatabaseConnection.IDatabaseConnectionFactory;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AdmissionDAO implements IPatientDAO, IAdmissionTypeDAO, IDiseaseDAO, IDoctorDAO, IBedAdmissionDAO, IAdmissionDetailsDAO, IWardAdmissionDAO {

  Connection connection = null;
  IDatabaseConnection databaseConnection;
  IDatabaseConnectionFactory databaseConnectionFactory;

  public AdmissionDAO() {
    databaseConnectionFactory = new DatabaseConnectionFactory();
    databaseConnection = databaseConnectionFactory.getDatabaseConnection();
  }
  
  @Override
  public String getPatient(String patientID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String patientName = null;
    ResultSet result;
    try {
      result = statement.executeQuery("SELECT * FROM patients WHERE patient_id = '" + patientID + "'");
      if (result.next()) {
        patientName = result.getString("first_name") + " " + result.getString("last_name");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return patientName;
  }
  
  @Override
  public boolean ifPatientExists(String patientID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);
    boolean output = false;
    
    String SQL = "SELECT * FROM patients WHERE patient_id = '" + patientID + "'";
    ResultSet result;
    try {
      result = statement.executeQuery(SQL);
      if (result.next()) {
        output = true;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return output;
  }
  
  @Override
  public String getAdmissionType(int admissionTypeID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String admissionType = null;
    ResultSet resultSet;
    try {
      resultSet = statement.executeQuery("SELECT * FROM admission_type WHERE admission_type_code = '" + admissionTypeID + "'");
      if (resultSet.next()) {
        admissionType = resultSet.getString("admission_type");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return admissionType;
  }

  @Override
  public Map<Integer, String> getAdmissionTypesList() {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Map<Integer, String> typeMap = new HashMap<>();
    ResultSet admissionTypes;
    try {
      admissionTypes = statement.executeQuery("SELECT * FROM admission_type");
      while (admissionTypes.next()) {
        typeMap.put(admissionTypes.getInt("admission_type_code"), admissionTypes.getString("admission_type"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    
    databaseConnection.closeDBConnection();
    return typeMap;
  }
  
  @Override
  public Map<Integer, String> getDiseaseList() {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Map<Integer, String> diseaseMap = new HashMap<>();
    ResultSet diseases;
    try {
      diseases = statement.executeQuery("SELECT * FROM disease");
      while (diseases.next()) {
        diseaseMap.put(diseases.getInt("disease_id"), diseases.getString("disease_code"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return diseaseMap;
  }

  @Override
  public String getDiseaseName(int diseaseID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String diseaseName = null;
    ResultSet disease;
    try {
      disease = statement.executeQuery("SELECT * FROM disease WHERE disease_id = '" + diseaseID + "'");
      while (disease.next()) {
        diseaseName = disease.getString("disease_code");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return diseaseName;
  }
  
  @Override
  public Map<Integer, String> getDoctorList() {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Map<Integer, String> doctorsMap = new HashMap<>();
    ResultSet doctors;
    try {
      doctors = statement.executeQuery("SELECT * FROM doctors");
      while (doctors.next()) {
        doctorsMap.put(doctors.getInt("id"), doctors.getString("first_name") + " " + doctors.getString("last_name"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return doctorsMap;
  }

  @Override
  public int getDoctor(int doctorID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    int doctorId = 0;
    ResultSet doctor;
    try {
      doctor = statement.executeQuery("SELECT * FROM doctors WHERE id = '" + doctorID + "'");
      while (doctor.next()) {
        doctorId = doctor.getInt("id");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return doctorId;
  }

  @Override
  public String getDoctorName(int doctorID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String doctorName = null;
    ResultSet doctor;
    try {
      doctor = statement.executeQuery("SELECT * FROM doctors WHERE id = '" + doctorID + "'");
      while (doctor.next()) {
        doctorName = doctor.getString("first_name") + " " + doctor.getString("last_name");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return doctorName;
  }

  @Override
  public Map<Integer, String> getWardsList() {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Map<Integer, String> wardMap = new HashMap<>();
    ResultSet wards;
    try {
      wards = statement.executeQuery("SELECT * FROM wards");
      while (wards.next()) {
        wardMap.put(wards.getInt("ward_id"), wards.getString("name"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return wardMap;
  }

  @Override
  public String getWardCode(int wardID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String wardCode = null;
    ResultSet wards;
    try {
      wards = statement.executeQuery("SELECT * FROM wards WHERE ward_id = '" + wardID + "'");
      if (wards.next()) {
        wardCode = wards.getString("name");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return wardCode;
  }

  @Override
  public Map<Integer, String> getAvailableBeds() {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Map<Integer, String> bedMap = new HashMap<>();
    ResultSet availableBeds;
    try {
      availableBeds = statement.executeQuery("SELECT * FROM beds WHERE isOccupied = 0");
      while (availableBeds.next()) {
        bedMap.put(availableBeds.getInt("bed_id"), availableBeds.getString("bed_code"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return bedMap;
  }

  @Override
  public String getBedCode(int bedID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    String bedCode = null;
    ResultSet resultSet;
    try {
      resultSet = statement.executeQuery("SELECT * FROM beds WHERE bed_id = '" + bedID + "'");
      if (resultSet.next()) {
        bedCode = resultSet.getString("bed_code");
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    
    databaseConnection.closeDBConnection();
    return bedCode;
  }

 

  @Override
  public Admission getAdmissionDetails(String patientID) {
    connection = databaseConnection.openDBConnection();
    Statement statement = databaseConnection.createStatement(connection);

    Admission admission = new Admission();
    String updateSQL = "SELECT * FROM admission WHERE patient_id = '" + patientID + "' and date_of_discharge is null";
  
    ResultSet admissionDetails;
    try {
      admissionDetails = statement.executeQuery(updateSQL);
      while (admissionDetails.next()) {
        admission.setAdmissionID(admissionDetails.getInt("admissionID"));
        admission.setPatientID(admissionDetails.getString("patient_id"));
        admission.setAdmissionType(admissionDetails.getInt("admission_type"));
        admission.setDiseaseID(admissionDetails.getInt("disease_code"));
        admission.setDoctorID(admissionDetails.getInt("doc_id"));
        admission.setWardID(admissionDetails.getInt("ward_id"));
        admission.setBedID(admissionDetails.getInt("bed_id"));
        admission.setAdmissionDate(admissionDetails.getDate("date_of_admission"));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    databaseConnection.closeDBConnection();
    
    return admission;
  }
}
