package BusinessLogicLayer.AdmissionDischargeModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AdmissionDAOTest {

    AdmissionDAOTest() throws SQLException {
    }

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

    ResultSet patient = statement.executeQuery("SELECT * FROM patients WHERE patient_id = 'doe999'");
    ResultSet admissionTypeList = statement.executeQuery("SELECT * FROM admission_type");
    ResultSet diseaseList = statement.executeQuery("SELECT * FROM disease");
    ResultSet disease = statement.executeQuery("SELECT * FROM disease WHERE disease_id = 3");
    ResultSet doctors = statement.executeQuery("SELECT * FROM doctors");
    ResultSet doctor = statement.executeQuery("SELECT * FROM doctors WHERE id = 4");
    ResultSet wards = statement.executeQuery("SELECT * FROM wards");
    ResultSet availableBeds = statement.executeQuery("SELECT * FROM beds WHERE isOccupied = 0");
    static Admission admission;

    // getPatient() returns patient record with provided patient ID.
    @Test
    void getPatient() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(patient,ad.getPatient("doe999"),"Test Failed!. Incorrect or No value received.");
    }

    // getAdmissionType() returns name of Admission type from given ID.
    @Test
    void getAdmissionType() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals("Covid",ad.getAdmissionType(1),"Test Failed!. Incorrect or No value received.");
    }


    // getAdmissionTypesList() returns ResultSet object with list of Admission Types from database.
    @Test
    void getAdmissionTypesList() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(admissionTypeList,ad.getAdmissionTypesList(),"Test Failed!. Incorrect or No value received.");
    }

    // getDiseaseList() returns ResultSet object with list of disease from database.
    @Test
    void getDiseaseList() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(diseaseList,ad.getDiseaseList(),"Test Failed!. Incorrect or No value received.");
    }

    // getDisease() returns Disease code associated with provided disease id.
    @Test
    void getDisease() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(disease,ad.getDisease(3),"Test Failed!. Incorrect or No value received.");
    }

    // getDoctorList() returns ResultSet object with list of Doctors from database.
    @Test
    void getDoctorList() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(doctors,ad.getDoctorList(),"Test Failed!. Incorrect or No value received.");
    }


    // getDisease() returns ResultSet object of Doctor associated with provided doctor id.
    @Test
    void getDoctor() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(doctor,ad.getDoctor(4),"Test Failed!. Incorrect or No value received.");
    }

    // getWardsList() returns ResultSet object with list of wards.
    @Test
    void getWardsList() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(wards,ad.getWardsList(),"Test Failed!. Incorrect or No value received.");
    }

    // getWardCode() returns Ward name associated with the provided ward id.
    @Test
    void getWardCode() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals("WARD A",ad.getWardCode(1),"Test Failed!. Incorrect or No value received.");
    }

    // getAvailableBeds() returns list of all the available beds as ResultSet object.
    @Test
    void getAvailableBeds() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(availableBeds,ad.getAvailableBeds(),"Test Failed!. Incorrect or No value received.");
    }


    // getbedCode() returns Bed code associated with bed id.
    @Test
    void getbedCode() throws SQLException {

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals("10002-5",ad.getbedCode(2),"Test Failed!. Incorrect or No value received.");
    }

    // saveAdmissionForm() saves the Admission object data in the database. This method returns 1 if user inserted in the system successfully.
    @Test
    void saveAdmissionForm() throws SQLException {

        admission.setAdmissionType(1);
        admission.setDiseaseID("Diesease");
        admission.setDoctorID("1");
        admission.setPatientID("doe999");
        admission.setWardID(1);
        admission.setBedID(2);

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(1,ad.saveAdmissionForm(admission),"Test Failed!. Incorrect or No value received.");
    }
}