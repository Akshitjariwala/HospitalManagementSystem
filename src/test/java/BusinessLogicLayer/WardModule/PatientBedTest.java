package BusinessLogicLayer.WardModule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PatientBedTest {

  @Test
  void getPatientNameTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals("John Due", pb.getPatientName(), "Patient Name is not matching");
  }

  @Test
  void setPatientNameTest() {
    PatientBed pb = new PatientBed();
    pb.setPatientName("John Due");
    assertEquals("John Due", pb.getPatientName(), "Patient Name is not matching");
  }

  @Test
  void getPatientIdTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals("patient1", pb.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void setPatientIdTest() {
    PatientBed pb = new PatientBed();
    pb.setPatientName("patient1");
    assertEquals("patient1", pb.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void getBedCodeTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals("10000-1", pb.getBedCode(), "Bed Code is not matching");
  }

  @Test
  void setBedCodeTest() {
    PatientBed pb = new PatientBed();
    pb.setBedCode("10000-1");
    assertEquals("10000-1", pb.getBedCode(), "Bed Code is not matching");
  }

  @Test
  void getBedIdTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals(25, pb.getBedId(), "Bed Id is not matching");
  }

  @Test
  void setBedIdTest() {
    PatientBed pb = new PatientBed();
    pb.setBedId(25);
    assertEquals(25, pb.getBedId(), "Bed Id is not matching");
  }

  @Test
  void getBedTypeTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals("General", pb.getBedType(), "Bed Type is not matching");
  }

  @Test
  void setBedTypeTest() {
    PatientBed pb = new PatientBed();
    pb.setBedType("General");
    assertEquals("General", pb.getBedType(), "Bed Type is not matching");
  }

  @Test
  void getWardNameTest() {
    PatientBed pb = new PatientBed("John Due", "10000-1", "WARD A", "General", 25, "patient1");
    assertEquals("WARD A", pb.getWardName(), "Ward Name is not matching");
  }

  @Test
  void setWardNameTest() {
    PatientBed pb = new PatientBed();
    pb.setWardName("WARD A");
    assertEquals("WARD A", pb.getWardName(), "Ward Name is not matching");
  }
}
