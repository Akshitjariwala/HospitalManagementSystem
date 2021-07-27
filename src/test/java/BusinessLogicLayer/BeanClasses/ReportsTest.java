package BusinessLogicLayer.BeanClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportsTest {

  @Test
  void getReportId() {
    Reports report = new Reports();
    int id = 12;
    report.setReportId(id);
    assertEquals(12, report.getReportId(), "The id doesnt match ");
  }

  @Test
  void setReportId() {
    Reports report = new Reports();
    int id = 12;
    report.setReportId(id);
    assertEquals(12, report.getReportId(), "The id doesnt match ");
  }

  @Test
  void getDoctorId() {
    Reports report = new Reports();
    String id = "2021";
    report.setDoctorId(id);
    assertEquals("2021", report.getDoctorId(), "The id doesnt match ");
  }

  @Test
  void setDoctorId() {
    Reports report = new Reports();
    String id = "2021";
    report.setDoctorId(id);
    assertEquals("2021", report.getDoctorId(), "The id doesnt match ");
  }

  @Test
  void getPatientId() {
    Reports report = new Reports();
    report.setPatientId("23");
    assertEquals("23", report.getPatientId(), "The id doesnt match ");
  }

  @Test
  void setPatientId() {
    Reports report = new Reports();
    report.setPatientId("23");
    assertEquals("23", report.getPatientId(), "The id doesnt match ");
  }

  @Test
  void getDiagnosisName() {
    Reports report = new Reports();
    report.setDiagnosisName("Malaria");
    assertEquals("Malaria", report.getDiagnosisName(), "The name doesnt match ");
  }

  @Test
  void setDiagnosisName() {
    Reports report = new Reports();
    report.setDiagnosisName("Malaria");
    assertEquals("Malaria", report.getDiagnosisName(), "The name doesnt match ");
  }

  @Test
  void getDate() {
    Reports report = new Reports();
    report.setDate("2021-04-22");
    assertEquals("2021-04-22", report.getDate(), "The date doesnt match ");
  }

  @Test
  void setDate() {
    Reports report = new Reports();
    report.setDate("2021-04-22");
    assertEquals("2021-04-22", report.getDate(), "The date doesnt match ");
  }

  @Test
  void getTestResult() {
    Reports report = new Reports();
    report.setTestResult("Negative");
    assertEquals("Negative", report.getTestResult(), "The result doesnt match ");
  }

  @Test
  void setTestResult() {
    Reports report = new Reports();
    report.setTestResult("Negative");
    assertEquals("Negative", report.getTestResult(), "The result doesnt match ");
  }

  @Test
  void getTestType() {
    Reports report = new Reports();
    report.setTestType("Blood-Sample");
    assertEquals("Blood-Sample", report.getTestType(), "The test doesnt match ");
  }

  @Test
  void setTestType() {
    Reports report = new Reports();
    report.setTestType("Blood-Sample");
    assertEquals("Blood-Sample", report.getTestType(), "The test doesnt match ");
  }
}