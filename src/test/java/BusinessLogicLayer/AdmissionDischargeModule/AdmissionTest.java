package BusinessLogicLayer.AdmissionDischargeModule;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AdmissionTest {

  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  Date date = new Date();

  @Test
  public void getAdmissionID() {
    Admission admission = new Admission();
    admission.setAdmissionID(50);
    assertEquals(50, admission.getAdmissionID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getPatientID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
    assertEquals("doe999", admission.getPatientID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getAdmissionType() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
    assertEquals(1, admission.getAdmissionType(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getWardID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
    assertEquals(1, admission.getWardID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getBedID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
    assertEquals(1, admission.getBedID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDoctorID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
    assertEquals(1, admission.getDoctorID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDiseaseID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, 6);
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
    assertEquals(java.time.LocalDate.now(),admission.getDischargeDate(),"Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDischargeComment(){
    Admission admission = new Admission();
    assertEquals("Discharged.",admission.getDischargeComment(),"Test Failed!. Incorrect or No value received.");
  }
}
