package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddReportsDAOTest {

  @Test
  void addReport() {
    Reports report = new Reports();
    report.setReportId(1);
    report.setDoctorId(5);
    report.setPatientId("Patient123");
    report.setDiagnosisName("Covid");
    report.setDate("2020-02-02");
    report.setTestResult("Negative");
    report.setTestType("Blood-Sample");
    assertEquals(1 + " " + 5 + " " + "Patient123" + " " + "Covid" + " " + "2020-02-02" + " " +
            "Negative" + " " + "Blood-Sample", report.getReportId() + " " + report.getDoctorId() + " " +
            report.getPatientId() + " " + report.getDiagnosisName() + " " + report.getDate() + " "
            + report.getTestResult() + " " + report.getTestType(), "The values are not valid");
  }
}