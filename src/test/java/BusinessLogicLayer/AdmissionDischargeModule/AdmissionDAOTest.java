package BusinessLogicLayer.AdmissionDischargeModule;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.AdmissionDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AdmissionDAOTest {

  private AdmissionDAO admissionDAO;

  @BeforeEach
  void setup() {
    admissionDAO = Mockito.mock(AdmissionDAO.class);
  }

  @Test
  void getPatient() {
    Mockito.when(admissionDAO.getPatient("doe999")).thenReturn("John Doe");
    assertEquals("John Doe", admissionDAO.getPatient("doe999"), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getAdmissionType() {
    Mockito.when(admissionDAO.getAdmissionType(1)).thenReturn("Covid");
    assertEquals("Covid", admissionDAO.getAdmissionType(1), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getAdmissionTypesList() {
    Map<Integer, String> admissionTypeList = new HashMap<>();
    admissionTypeList.put(1, "Covid");
    admissionTypeList.put(2, "General Care");
    admissionTypeList.put(3, "ICU");
    admissionTypeList.put(4, "Long Term Acute Care");
    admissionTypeList.put(5, "Surgery");
    admissionTypeList.put(6, "Maternity");
    Mockito.when(admissionDAO.getAdmissionTypesList()).thenReturn(admissionTypeList);
    assertEquals(admissionTypeList, admissionDAO.getAdmissionTypesList(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDiseaseList() {
    Map<Integer, String> diseaseList = new HashMap<>();
    diseaseList.put(1, "Disease");
    diseaseList.put(2, "Disease");
    diseaseList.put(3, "Disease");
    diseaseList.put(4, "Disease");
    diseaseList.put(5, "Disease");
    diseaseList.put(6, "Disease");
    Mockito.when(admissionDAO.getDiseaseList()).thenReturn(diseaseList);
    assertEquals(diseaseList, admissionDAO.getDiseaseList(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDiseaseName() {
    Mockito.when(admissionDAO.getDiseaseName(3)).thenReturn("DI100012");
    assertEquals("DI100012", admissionDAO.getDiseaseName(3), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDiseaseCode() {
    Mockito.when(admissionDAO.getDiseaseName(1)).thenReturn("COVID-19");
    assertEquals("COVID-19", admissionDAO.getDiseaseName(1), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDoctorList() {
    Map<Integer, String> doctorList = new HashMap<>();
    doctorList.put(1, "Hemant Desai");
    doctorList.put(2, "Harit Parekh");
    doctorList.put(3, "vaishnavi jupudi");
    doctorList.put(4, "Aayush Shah");
    doctorList.put(5, "Avani Kothiya");
    doctorList.put(6, "doctor doct7");
    doctorList.put(7, "Janki Kheni");
    doctorList.put(8, "vaishnavi jup");

    Mockito.when(admissionDAO.getDoctorList()).thenReturn(doctorList);
    assertEquals(doctorList, admissionDAO.getDoctorList(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDoctor() {
    Mockito.when(admissionDAO.getDoctor(4)).thenReturn(4);
    assertEquals(4, admissionDAO.getDoctor(4), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getDoctorName() {
    Mockito.when(admissionDAO.getDoctorName(4)).thenReturn("Aayush Shah");
    assertEquals("Aayush Shah", admissionDAO.getDoctorName(4), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getWardsList() {
    Map<Integer, String> wardList = new HashMap<>();
    wardList.put(1, "WARD A");
    wardList.put(2, "WARD B");
    wardList.put(3, "WARD C");
    wardList.put(4, "WARD D");
    Mockito.when(admissionDAO.getWardsList()).thenReturn(wardList);
    assertEquals(wardList, admissionDAO.getWardsList(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getWardCode() {
    Mockito.when(admissionDAO.getWardCode(1)).thenReturn("WARD A");
    assertEquals("WARD A", admissionDAO.getWardCode(1), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getAvailableBeds() {
    Map<Integer, String> bedList = new HashMap<>();
    bedList.put(1, "10002-1");
    bedList.put(2, "10002-5");
    bedList.put(3, "10002-8");
    bedList.put(4, "10002-9");
    bedList.put(5, "10002-17");
    Mockito.when(admissionDAO.getAvailableBeds()).thenReturn(bedList);
    assertEquals(bedList, admissionDAO.getAvailableBeds(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void getBedCode() {
    Mockito.when(admissionDAO.getBedCode(2)).thenReturn("10002-5");
    assertEquals("10002-5", admissionDAO.getBedCode(2), "Test Failed!. Incorrect or No value received.");

  }

  @Test
  void ifPatientExists() {
    Mockito.when(admissionDAO.ifPatientExists("doe999")).thenReturn(Boolean.valueOf("true"));
    assertTrue(admissionDAO.ifPatientExists("doe999"), "Test Failed!. False or Incorrect value received.");
  }

  @Test
  void getAdmissionDetails() {
    Admission admission = new Admission("doe999", 3, 5, 2, 7, 5);
    Mockito.when(admissionDAO.getAdmissionDetails("doe999")).thenReturn(admission);
    Admission testAdmission = admissionDAO.getAdmissionDetails("doe999");
    assertEquals(admission.getPatientID(), testAdmission.getPatientID(), "Test Failed!. Incorrect or No value received.");
  }
}