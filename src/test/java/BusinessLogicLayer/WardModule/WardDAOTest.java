package BusinessLogicLayer.WardModule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WardDAOTest {

  private WardDAO wardDAO;

  @BeforeEach
  void setup() {
    wardDAO = Mockito.mock(WardDAO.class);
  }

  @Test
  void getWardTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");

    Mockito.when(wardDAO.getWard(1)).thenReturn(ward);
    assertEquals(ward.getWardName(), wardDAO.getWard(1).getWardName(), "Ward is not matching");
  }

  @Test
  void getBedsTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed1 = new Bed(1, "10000-17", ward, true, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");
    ArrayList<Bed> bedArrayList = new ArrayList<>(Arrays.asList(bed1, bed2));

    Mockito.when(wardDAO.getWardBeds(1)).thenReturn(bedArrayList);
    assertEquals(wardDAO.getWardBeds(1).size(), bedArrayList.size(), "No. of Bed in ward is not matching");
  }

  @Test
  void getPatientBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");

    Bed bed1 = new Bed(1, "10000-17", ward, false, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");

    PatientBed pb1 = new PatientBed("John Due", bed2, "patient1");
    PatientBed pb2 = new PatientBed("John Due", bed1, "patient2");
    ArrayList<PatientBed> patientBedArrayList = new ArrayList<>(Arrays.asList(pb1, pb2));

    Mockito.when(wardDAO.getPatientBed(1)).thenReturn(patientBedArrayList);
    assertEquals(wardDAO.getPatientBed(1).size(), patientBedArrayList.size(), "No. of Patient-Bed in ward is not matching");
  }
}
