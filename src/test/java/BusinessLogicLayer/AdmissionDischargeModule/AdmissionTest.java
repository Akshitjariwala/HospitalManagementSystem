package BusinessLogicLayer.AdmissionDischargeModule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdmissionTest {

  @Test
  public void getPatientID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals("doe999", admission.getPatientID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getAdmissionType() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals(1, admission.getAdmissionType(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getWardID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals(1, admission.getWardID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getBedID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals(1, admission.getBedID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDoctorID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals(1, admission.getDoctorID(), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  public void getDiseaseID() {
    Admission admission = new Admission("doe999", 1, 1, 1, 1, "DI100012");
    assertEquals("DI100012", admission.getDiseaseID(), "Test Failed!. Incorrect or No value received.");
  }
}
