package BusinessLogicLayer.BeanClasses;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientBedTest {

  @Test
  void getPatientNameTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    PatientBed pb = new PatientBed("John Due", bed, "patient1");
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
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    PatientBed pb = new PatientBed("John Due", bed, "patient1");
    assertEquals("patient1", pb.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void setPatientIdTest() {
    PatientBed pb = new PatientBed();
    pb.setPatientId("patient1");
    assertEquals("patient1", pb.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void getBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    PatientBed pb = new PatientBed("John Due", bed, "patient1");
    assertEquals(bed, pb.getBed(), "Bed is not matching");
  }

  @Test
  void setBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed = new Bed(1, "10000-1", ward, true, "General");
    PatientBed pb = new PatientBed();
    pb.setBed(bed);
    assertEquals(bed, pb.getBed(), "Bed is not matching");
  }
}
