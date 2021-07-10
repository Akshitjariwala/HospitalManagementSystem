package BusinessLogicLayer.AdmissionDischargeModule;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AdmissionTest {

  @Test
  public void getAdmissionID() {
    Admission admission = new Admission();
    admission.setAdmissionID(50);
    assertEquals(50, admission.getAdmissionID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getPatientID() {
    Admission admission = new Admission();
    admission.setPatientID("doe999");
    assertEquals("doe999", admission.getPatientID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getAdmissionType() {
    Admission admission = new Admission();
    admission.setAdmissionType(1);
    assertEquals(1, admission.getAdmissionType(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getWardID() {
    Admission admission = new Admission();
    admission.setWardID(1);
    assertEquals(1, admission.getWardID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getBedID() {
    Admission admission = new Admission();
    admission.setBedID(1);
    assertEquals(1, admission.getBedID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDoctorID() {
    Admission admission = new Admission();
    admission.setDoctorID(1);
    assertEquals(1, admission.getDoctorID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDiseaseID() {
    Admission admission = new Admission();
    admission.setDiseaseID(6);
    assertEquals(6, admission.getDiseaseID(), "Test Failed!. Incorrect or No value received.");
  }

  // getAdmissionDate() returns the date of Admission.
  @Test
  public void getAdmissionDate(){
    Admission admission = new Admission();
    admission.setAdmissionDate(java.time.LocalDate.now());
    assertEquals(java.time.LocalDate.now(),admission.getAdmissionDate(),"Test Failed!. Incorrect or No value received.");
  }

  // getDischargeDate() returns the date of Discharge.
  @Test
  public void getDischargeDate(){
    Admission admission = new Admission();
    admission.setDischargeDate(java.time.LocalDate.now());
    assertEquals(java.time.LocalDate.now(),admission.getDischargeDate(),"Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDischargeComment(){
    Admission admission = new Admission();
    admission.setDischargeComment("Discharged");
    assertEquals("Discharged",admission.getDischargeComment(),"Test Failed!. Incorrect or No value received.");
  }
}
