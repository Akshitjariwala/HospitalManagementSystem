package DatabaseLayer.ActionDatabase.Admin.Reports;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.ViewReportsDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;

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
    reports.setDoctorId(2);
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
  }

  @Test
  void checkPatientId() {
  }

  @Test
  void updateReport() {
  }

  @Test
  void getReportsDetails() {
  }
}