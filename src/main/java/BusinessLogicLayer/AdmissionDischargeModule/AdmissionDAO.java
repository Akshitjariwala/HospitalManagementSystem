package BusinessLogicLayer.AdmissionDischargeModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdmissionDAO {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;
    public static LocalDate todayDate = LocalDate.now();

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getPatient(String patientID) throws SQLException {
        String patientName=null;
        ResultSet result = statement.executeQuery("SELECT * FROM patients WHERE patient_id = '" + patientID + "'");
        if(result.next()){
            patientName = result.getString("first_name") + " " + result.getString("last_name");
        }
        return patientName;
    }


    public String getAdmissionType(int admissionTypeID) throws SQLException {
        String admissionType = null;
        ResultSet r = statement.executeQuery("SELECT * FROM admission_type WHERE admission_type_code = '" + admissionTypeID + "'");
        if (r.next()) {
            admissionType = r.getString("admission_type");
        }
        return admissionType;
    }

    public ArrayList<String> getAdmissionTypesList() throws SQLException {
        ArrayList<String> type = new ArrayList<>();
        ResultSet types = statement.executeQuery("SELECT * FROM admission_type");

        while(types.next()){
            type.add(types.getString("admission_type"));
        }
        return type;
    }

    public ArrayList<String> getDiseaseList() throws SQLException {
        ArrayList<String> disease = new ArrayList<>();
        ResultSet diseases = statement.executeQuery("SELECT * FROM disease");

        while(diseases.next()){
            disease.add(diseases.getString("disease_name"));
        }
        return disease;
    }

    public String getDiseaseName(int diseaseID) throws SQLException {
        String diseaseName = null;
        ResultSet disease = statement.executeQuery("SELECT * FROM disease WHERE disease_id = '" + diseaseID + "'");

        while(disease.next()){
            diseaseName = disease.getString("disease_name");
        }

        return diseaseName;
    }

    public String getDiseaseCode(int diseaseID) throws SQLException {
        String diseaseCode = null;
        ResultSet disease = statement.executeQuery("SELECT * FROM disease WHERE disease_id = '" + diseaseID + "'");

        while(disease.next()){
            diseaseCode = disease.getString("disease_code");
        }
        return diseaseCode;
    }

    public ArrayList<String> getDoctorList() throws SQLException {
        ArrayList<String> doctorList = new ArrayList<>();
        ResultSet doctors = statement.executeQuery("SELECT * FROM doctors");

        while(doctors.next()){
            doctorList.add(doctors.getString("first_name")+" "+doctors.getString("last_name"));
        }
        return doctorList;
    }

    public String getDoctor(int doctorID) throws SQLException {
        String doctorId = null;
        ResultSet doctor = statement.executeQuery("SELECT * FROM doctors WHERE id = '" + doctorID + "'");

        while(doctor.next()){
            doctorId = doctor.getString("doc_id");
        }
        return doctorId;
    }

    public String getDoctorName(int doctorID) throws SQLException {
        String doctorName = null;
        ResultSet doctor = statement.executeQuery("SELECT * FROM doctors WHERE id = '" + doctorID + "'");

        while(doctor.next()){
            doctorName = doctor.getString("first_name")+" "+doctor.getString("last_name");
        }
        return doctorName;
    }

    public ArrayList<String> getWardsList() throws SQLException {
        ArrayList<String> wardList = new ArrayList<String>();
        ResultSet wards = statement.executeQuery("SELECT * FROM wards");

        while(wards.next()){
            wardList.add(wards.getString("name"));
        }

        return wardList;
    }

    public String getWardCode(int wardID) throws SQLException {
        String wardCode=null;
        ResultSet r = statement.executeQuery("SELECT * FROM wards WHERE ward_id = '" + wardID + "'");
        if (r.next()) {
            wardCode = r.getString("name");
        }
        return wardCode;
    }

    public ArrayList<String> getAvailableBeds() throws SQLException {
        ArrayList<String> bedList = new ArrayList<String>();
        ResultSet availableBeds = statement.executeQuery("SELECT * FROM beds WHERE isOccupied = 0");

        while(availableBeds.next()){
            bedList.add(availableBeds.getString("bed_code"));
        }

        return bedList;
    }

    public String getBedCode(int bedID) throws SQLException {

        String bedCode = null;
        ResultSet r = statement.executeQuery("SELECT * FROM beds WHERE bed_id = '" + bedID + "'");
        if (r.next()) {
            bedCode = r.getString("bed_code");
        }
        return bedCode;
    }

    public int saveAdmissionForm(Admission admission) throws SQLException {

        int result;
        PreparedStatement ps =connection.prepareStatement("INSERT INTO admission(patient_id,date_of_admission,admission_type,ward_id,bed_id,doc_id,diesease_code) VALUES(?,?,?,?,?,?,?)");

        ps.setString(1,admission.getPatientID());
        ps.setDate(2, Date.valueOf(todayDate));
        ps.setInt(3,admission.getAdmissionType());
        ps.setInt(4,admission.getWardID());
        ps.setInt(5,admission.getBedID());
        ps.setString(6,admission.getDoctorID());
        ps.setString(7,admission.getDiseaseID());

        result = ps.executeUpdate();

        if(result==1){
            statement.executeUpdate("UPDATE beds SET isOccupied = 1 WHERE bed_id = "+admission.getBedID());
        }
        return result;
    }
}
