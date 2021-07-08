package BusinessLogicLayer.WardModule;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WardDAOTest {

  @Test
  void getWardTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    WardDAO wardDAO = new WardDAO();
    assertEquals(ward.getWardName(), wardDAO.getWard(1).getWardName(), "Ward is not matching");
  }

  @Test
  void getBedsTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed1 = new Bed(1, "10000-17", ward, false, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");
    Bed bed3 = new Bed(1, "10002-1", ward, false, "General");
    ArrayList<Bed> bedArrayList = new ArrayList<>(Arrays.asList(bed1, bed2, bed3));

    WardDAO wardDAO = new WardDAO();
    assertEquals(bedArrayList.size(), wardDAO.getWardBeds(1).size(), "No. of Bed in ward is not matching");
  }

  @Test
  void getPatientBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");

    Bed bed1 = new Bed(1, "10000-17", ward, false, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");
    Bed bed3 = new Bed(1, "10002-1", ward, false, "General");

    PatientBed pb1 = new PatientBed("John Due", bed2, "patient1");
    PatientBed pb2 = new PatientBed("John Due", bed1, "patient2");
    ArrayList<PatientBed> patientBedArrayList = new ArrayList<>(Arrays.asList(pb1, pb2));

    WardDAO wardDAO = new WardDAO();
    assertEquals(patientBedArrayList.size(), wardDAO.getPatientBed(1).size(), "No. of Patient-Bed in ward is not matching");
  }
}
