package BusinessLogicLayer.WardModule;

import BusinessLogicLayer.BeanClasses.Bed;
import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.ActionDatabase.Admin.Beds.BedDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BedDAOTest {

  private IBedDAO iBedDAO;

  @BeforeEach
  void setup() {
    iBedDAO = Mockito.mock(BedDAO.class);
  }

  @Test
  void getBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed1 = new Bed(1, "10000-17", ward, true, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");
    ArrayList<Bed> bedArrayList = new ArrayList<>(Arrays.asList(bed1, bed2));

    Mockito.when(iBedDAO.getWardBeds(1)).thenReturn(bedArrayList);
    assertEquals(iBedDAO.getWardBeds(1).size(), bedArrayList.size(), "No. of Bed in ward is not matching");
  }

  @Test
  void checkBedAVailablityTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");
    Bed bed1 = new Bed(1, "10000-17", ward, false, "ICU");
    BedCounts bd = new BedCounts();
    bd.setBedType(bed1.getBedType());
    bd.setNumberOfBeds(2);
    bd.setWard(ward);
    ArrayList<BedCounts> bedcount = new ArrayList<>(Collections.singletonList(bd));
    Mockito.when(iBedDAO.showCurrentAvailableBeds()).thenReturn(bedcount);
    assertEquals(iBedDAO.showCurrentAvailableBeds().size(), bedcount.size(), "Mismatch in bed availability");
  }

  @Test
  void getPatientBedTest() {
    Ward ward = new Ward(1, "WARD A", "COVID", "C Wing", 100, "General");

    Bed bed1 = new Bed(1, "10000-17", ward, false, "ICU");
    Bed bed2 = new Bed(1, "10002-12", ward, true, "ICU");

    PatientBed pb1 = new PatientBed("John Due", bed2, "patient1");
    PatientBed pb2 = new PatientBed("John Due", bed1, "patient2");
    ArrayList<PatientBed> patientBedArrayList = new ArrayList<>(Arrays.asList(pb1, pb2));

    Mockito.when(iBedDAO.getPatientBed(1)).thenReturn(patientBedArrayList);
    assertEquals(iBedDAO.getPatientBed(1).size(), patientBedArrayList.size(), "No. of Patient-Bed in ward is not matching");
  }
}
