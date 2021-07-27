package DatabaseLayer.ActionDatabase.Admin.Reports;

import BusinessLogicLayer.BeanClasses.Reports;
import BusinessLogicLayer.BeanClasses.Ward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ManageReportsDAOTest {

  private ManageReportsDAO manageReportsDAO;

  @BeforeEach
  void setup() {
    manageReportsDAO = Mockito.mock(ManageReportsDAO.class);
  }

  @Test
  void addReport() {
    Reports reports = new Reports();
    reports.setReportId(1);
    reports.setDoctorId("2");
    reports.setDate("27-07-2021");
    reports.setDiagnosisName("Covid-19");
    reports.setPatientId("vaishnavi");
    reports.setTestResult("Negative");
    reports.setTestType("RTPCR");
    Mockito.when(manageReportsDAO.addReport(reports)).thenReturn(1);
    assertEquals(1, manageReportsDAO.addReport(reports), "The values are not inserted");
  }

  @Test
  void checkDoctorId() {
    Mockito.when(manageReportsDAO.checkDoctorId("2")).thenReturn(1);
    assertEquals(1, manageReportsDAO.checkDoctorId("2"), "The values are not present");
  }

  @Test
  void checkPatientId() {
    Mockito.when(manageReportsDAO.checkPatientId("vaishnavi")).thenReturn("vaishnavi");
    assertEquals("vaishnavi", manageReportsDAO.checkPatientId("vaishnavi"), "The values are not present");
  }

  @Test
  void getReportsDetails() {
    Reports r1 = new Reports();
    r1.setReportId(1);
    r1.setDoctorId("2");
    r1.setDate("11-07-2021");
    r1.setDiagnosisName("Covid-19");
    r1.setPatientId("vishal123");
    r1.setTestResult("Negative");
    r1.setTestType("RTPCR");
    Mockito.when(manageReportsDAO.getReportsDetails(1)).thenReturn(r1);
    assertEquals(r1, manageReportsDAO.getReportsDetails(1));
  }

  @Test
  void updateReport() {
    Ward ward = new Ward();

    ward.setWardId(11);
    ward.setWardType("General");
    ward.setWardName("General");
    ward.setLocation("Wing B");
    ward.setTotalBeds(25);
    ward.setBedType("ICU");

    assertEquals(11 + " " + "General" + " " + "General" + " " + "Wing B" + " " + 25 + " " + "ICU",
            ward.getWardId() + " " + ward.getWardType() + " " + ward.getWardName() + " " +
                    ward.getLocation() + " " + ward.getTotalBeds() + " " +
                    ward.getBedType(), "The values are not valid");
  }
}