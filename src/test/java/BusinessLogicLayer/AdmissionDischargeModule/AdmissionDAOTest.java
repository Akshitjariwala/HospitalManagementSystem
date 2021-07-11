package BusinessLogicLayer.AdmissionDischargeModule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdmissionDAOTest {

  private AdmissionDAO admissionDAO;
  private long timeToMil = System.currentTimeMillis();
  private Date date = new Date(timeToMil);

  @BeforeEach
  void setup() {
    admissionDAO = Mockito.mock(AdmissionDAO.class);
  }

  private AdmissionDAO demoDAO = new AdmissionDAO();

  // This Returns patient record with provided patient ID.
  @Test
  void getPatient() throws SQLException {
    Mockito.when(admissionDAO.getPatient("doe999")).thenReturn("John Doe");
    assertEquals("John Doe", admissionDAO.getPatient("doe999"), "Test Failed!. Incorrect or No value received.");
  }

  // getAdmissionType() returns name of Admission type from given ID.
  @Test
  void getAdmissionType() throws SQLException {
    Mockito.when(admissionDAO.getAdmissionType(1)).thenReturn("Covid");
    assertEquals("Covid", admissionDAO.getAdmissionType(1), "Test Failed!. Incorrect or No value received.");
  }


  // getAdmissionTypesList() returns ResultSet object with list of Admission Types from database.
  @Test
  void getAdmissionTypesList() throws SQLException {
    ArrayList<String> admissionTypeList = new ArrayList<>();
    admissionTypeList.add("Covid");
    admissionTypeList.add("General Care");
    admissionTypeList.add("ICU");
    admissionTypeList.add("Long Term Accoute Care");
    admissionTypeList.add("Surgery");
    admissionTypeList.add("Maternity");
    Mockito.when(admissionDAO.getAdmissionTypesList()).thenReturn(admissionTypeList);
    assertEquals(admissionTypeList, admissionDAO.getAdmissionTypesList(), "Test Failed!. Incorrect or No value received.");
  }

  // getDiseaseList() returns ArrayList object with list of disease from database.
  @Test
  void getDiseaseList() throws SQLException {
    ArrayList<String> diseaseList = new ArrayList<>();
    diseaseList.add("Disease");
    diseaseList.add("Disease");
    diseaseList.add("Disease");
    diseaseList.add("Disease");
    diseaseList.add("Disease");
    diseaseList.add("Disease");
    Mockito.when(admissionDAO.getDiseaseList()).thenReturn(diseaseList);
    assertEquals(diseaseList, admissionDAO.getDiseaseList(), "Test Failed!. Incorrect or No value received.");
  }

  // getDisease() returns Disease code associated with provided disease id.
  @Test
  void getDiseaseName() throws SQLException {
    Mockito.when(admissionDAO.getDiseaseName(3)).thenReturn("DI100012");
    assertEquals("DI100012", admissionDAO.getDiseaseName(3), "Test Failed!. Incorrect or No value received.");
  }

  //
  @Test
  void getDiseaseCode() throws SQLException {
    Mockito.when(admissionDAO.getDiseaseName(1)).thenReturn("COVID-19");
    assertEquals("COVID-19", admissionDAO.getDiseaseName(1), "Test Failed!. Incorrect or No value received.");
  }

  // getDoctorList() returns ArrayList object with list of Doctors from database.
  @Test
  void getDoctorList() throws SQLException {
    ArrayList<String> doctorList = new ArrayList<>();
    doctorList.add("Hemant Desai");
    doctorList.add("Harit Parekh");
    doctorList.add("vaishnavi jupudi");
    doctorList.add("Aayush Shah");
    doctorList.add("Avani Kothiya");
    doctorList.add("Janki Kheni");
    doctorList.add("vaishnavi jup");
    doctorList.add("doctor doct7");
    Mockito.when(admissionDAO.getDoctorList()).thenReturn(doctorList);
    assertEquals(doctorList, admissionDAO.getDoctorList(), "Test Failed!. Incorrect or No value received.");
  }


  // getDoctor() returns Doctor Code associated with provided doctor id.
  @Test
  void getDoctor() throws SQLException {
    Mockito.when(admissionDAO.getDoctor(4)).thenReturn(4);
    assertEquals(4, admissionDAO.getDoctor(4), "Test Failed!. Incorrect or No value received.");
  }

  // getDoctorName() returns  DoctorName associated with provided doctor id.
  @Test
  void getDoctorName() throws SQLException {
    Mockito.when(admissionDAO.getDoctorName(4)).thenReturn("Aayush Shah");
    assertEquals("Aayush Shah", admissionDAO.getDoctorName(4), "Test Failed!. Incorrect or No value received.");
  }

  // getWardsList() returns ArrayList object with list of wards.
  @Test
  void getWardsList() throws SQLException {
    ArrayList<String> wardList = new ArrayList<>();
    wardList.add("WARD A");
    wardList.add("WARD B");
    wardList.add("WARD C");
    wardList.add("WARD D");
    Mockito.when(admissionDAO.getWardsList()).thenReturn(wardList);
    assertEquals(wardList, admissionDAO.getWardsList(), "Test Failed!. Incorrect or No value received.");
  }

  // getWardCode() returns Ward name associated with the provided ward id.
  @Test
  void getWardCode() throws SQLException {
    Mockito.when(admissionDAO.getWardCode(1)).thenReturn("WARD A");
    assertEquals("WARD A", admissionDAO.getWardCode(1), "Test Failed!. Incorrect or No value received.");
  }

  // getAvailableBeds() returns list of all the available beds as ArrayList object
  @Test
  void getAvailableBeds() throws SQLException {
    ArrayList<String> bedList = new ArrayList<>();
    bedList.add("10002-1");
    bedList.add("10002-5");
    bedList.add("10002-8");
    bedList.add("10002-9");
    bedList.add("10002-17");
    Mockito.when(admissionDAO.getAvailableBeds()).thenReturn(bedList);
    assertEquals(bedList, admissionDAO.getAvailableBeds(), "Test Failed!. Incorrect or No value received.");
  }


  // getBedCode() returns Bed code associated with bed id.
  @Test
  void getBedCode() throws SQLException {
    Mockito.when(admissionDAO.getBedCode(2)).thenReturn("10002-5");
    assertEquals("10002-5", admissionDAO.getBedCode(2), "Test Failed!. Incorrect or No value received.");
  }

  // saveAdmissionForm() saves the Admission object data in the database.
  @Test
  void saveAdmissionForm() throws SQLException {
    Admission admission = new Admission("doe999", 1, 4, 5, 7, 6);
    Mockito.when(admissionDAO.saveAdmissionForm(admission)).thenReturn(1);
    assertEquals(1, admissionDAO.saveAdmissionForm(admission), "Test Failed!. Incorrect or No value received.");
  }

/*  ifPatientExists() checks if user exists in the system.
    If exists it returns true
  else it returns false.*/
  @Test
  void ifPatientExists() throws SQLException {
    Mockito.when(admissionDAO.ifPatientExists("doe999")).thenReturn(Boolean.valueOf("true"));
    assertTrue(admissionDAO.ifPatientExists("doe999"),"Test Failed!. False or Incorrect value received.");
  }

  // This method will return Admission details of the patient.
  @Test
  void getAdmissionDetails() throws SQLException {
    Admission admission = new Admission("doe999", 3, 5, 2, 7, 5);
    Mockito.when(admissionDAO.getAdmissionDetails("doe999")).thenReturn(admission);
    Admission testAdmission = admissionDAO.getAdmissionDetails("doe999");
    assertEquals(admission.getPatientID(),testAdmission.getPatientID(),"Test Failed!. Incorrect or No value received.");
  }

  @Test
  void updateAdmissionForm() throws SQLException {
    Admission admission = new Admission("doe999", 2, 3, 1, 3, 4);
    admission.setAdmissionID(50);
    Mockito.when(admissionDAO.updateAdmissionForm(admission)).thenReturn(1);
    assertEquals(1,admissionDAO.updateAdmissionForm(admission),"Test Failed!. Incorrect or No value received.");
  }

  // dischargePatient() saves discharge information in the database.
  // Returns 1 is successful. Returns 0 if update fails.
  @Test
  void dischargePatient() throws SQLException {
    Admission admission = new Admission("doe999", 2, 3, 1, 3, 4);
    admission.setDischargeDate(date);
    admission.setAdmissionID(50);
    admission.setDischargeComment("Patient is allowed to leave.");
    Mockito.when(admissionDAO.dischargePatient(admission)).thenReturn(Boolean.valueOf("true"));
    assertTrue(admissionDAO.dischargePatient(admission),"Test Failed!. Incorrect or No value received.");
  }

}