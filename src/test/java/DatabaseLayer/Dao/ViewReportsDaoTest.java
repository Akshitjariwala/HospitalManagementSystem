package DatabaseLayer.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.ViewReportsDao;

class ViewReportsDaoTest {
  private ViewReportsDao viewreportsDAO;

  @BeforeEach
  void setup() {
    viewreportsDAO = Mockito.mock(ViewReportsDao.class);
  }

  @Test
  void test_getAllReports() {
    Reports r1 = new Reports();
    r1.setReportId(1);
    r1.setDoctorId("2");
    r1.setDate("11-07-2021");
    r1.setDiagnosisName("Covid-19");
    r1.setPatientId("vishal123");
    r1.setTestResult("Negative");
    r1.setTestType("RTPCR");
    ArrayList<Reports> report = new ArrayList<>(Collections.singletonList(r1));
    Mockito.when(viewreportsDAO.getAllReports(1)).thenReturn(report);
    assertEquals(1, report.size());


  }

  @Test
  void test_getAllPatientReports() {
    Reports r1 = new Reports();
    r1.setReportId(1);
    r1.setDoctorId("2");
    r1.setDate("11-07-2021");
    r1.setDiagnosisName("Covid-19");
    r1.setPatientId("vishal123");
    r1.setTestResult("Negative");
    r1.setTestType("RTPCR");
    ArrayList<Reports> report = new ArrayList<>(Collections.singletonList(r1));
    Mockito.when(viewreportsDAO.getAllReports(1)).thenReturn(report);
    assertEquals(1, report.size());


  }

}
