package BusinessLogicLayer.AdmissionDischargeModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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

    // This Returns patient record with provided patient ID.
    @Test
    void getPatient() throws SQLException {
        ArrayList<String> patient = new ArrayList<String>();
        patient.add("");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("John Doe",ad.getPatient("doe999"),"Test Failed!. Incorrect or No value received.");
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
        ArrayList<String> admissionTypeList = new ArrayList<String>();
        admissionTypeList.add("Covid");
        admissionTypeList.add("General Care");
        admissionTypeList.add("ICU");
        admissionTypeList.add("Long Term Accoute Care");
        admissionTypeList.add("Surgery");
        admissionTypeList.add("Maternity");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals(admissionTypeList,ad.getAdmissionTypesList(),"Test Failed!. Incorrect or No value received.");
    }

    // getDiseaseList() returns ArrayList object with list of disease from database.
    @Test
    void getDiseaseList() throws SQLException {
        ArrayList<String> diseaseList = new ArrayList<String>();
        diseaseList.add("Diesease");
        diseaseList.add("Diesease");
        diseaseList.add("Diesease");
        diseaseList.add("Diesease");
        diseaseList.add("Diesease");
        diseaseList.add("Diesease");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals(diseaseList,ad.getDiseaseList(),"Test Failed!. Incorrect or No value received.");
    }

    // getDisease() returns Disease code associated with provided disease id.
    @Test
    void getDiseaseName() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("Diesease",ad.getDiseaseName(3),"Test Failed!. Incorrect or No value received.");
    }

    //
    @Test
    void getDiseaseCode() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("COVID-19",ad.getDiseaseCode(1),"Test Failed!. Incorrect or No value received.");
    }

    // getDoctorList() returns ArrayList object with list of Doctors from database.
    @Test
    void getDoctorList() throws SQLException {
        ArrayList<String> doctorList = new ArrayList<String>();
        doctorList.add("Hemant Desai");
        doctorList.add("Harit Parekh");
        doctorList.add("vaishnavi jupudi");
        doctorList.add("Aayush Shah");
        doctorList.add("Avani Kothiya");
        doctorList.add("Janki Kheni");
        doctorList.add("vaishnavi jup");
        doctorList.add("doctor doct7");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals(doctorList,ad.getDoctorList(),"Test Failed!. Incorrect or No value received.");
    }


    // getDoctor() returns Doctor Code associated with provided doctor id.
    @Test
    void getDoctor() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("123000034",ad.getDoctor(4),"Test Failed!. Incorrect or No value received.");
    }

    // getDoctorName() returns  DoctorName associated with provided doctor id.
    @Test
    void getDoctorName() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("Aayush Shah",ad.getDoctorName(4),"Test Failed!. Incorrect or No value received.");
    }

    // getWardsList() returns ArrayList object with list of wards.
    @Test
    void getWardsList() throws SQLException {
        ArrayList<String> wardList = new ArrayList<String>();
        wardList.add("WARD A");
        wardList.add("WARD B");
        wardList.add("WARD C");
        wardList.add("WARD D");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals(wardList,ad.getWardsList(),"Test Failed!. Incorrect or No value received.");
    }

    // getWardCode() returns Ward name associated with the provided ward id.
    @Test
    void getWardCode() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("WARD A",ad.getWardCode(1),"Test Failed!. Incorrect or No value received.");
    }

    // getAvailableBeds() returns list of all the available beds as ArrayList object
    @Test
    void getAvailableBeds() throws SQLException {
        ArrayList<String> bedList = new ArrayList<String>();
        bedList.add("10002-1");
        bedList.add("10002-5");
        bedList.add("10002-8");
        bedList.add("10002-9");
        bedList.add("10002-17");

        AdmissionDAO ad = new AdmissionDAO();
        assertEquals(bedList,ad.getAvailableBeds(),"Test Failed!. Incorrect or No value received.");
    }


    // getBedCode() returns Bed code associated with bed id.
    @Test
    void getBedCode() throws SQLException {
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals("10002-5",ad.getBedCode(2),"Test Failed!. Incorrect or No value received.");
    }

    // saveAdmissionForm() saves the Admission object data in the database.
    @Test
    void saveAdmissionForm() throws SQLException {
        Admission admission = new Admission("doe999",1,4,5,"7","DI100015");
        AdmissionDAO ad = new AdmissionDAO();

        assertEquals(1,ad.saveAdmissionForm(admission),"Test Failed!. Incorrect or No value received.");
    }
}