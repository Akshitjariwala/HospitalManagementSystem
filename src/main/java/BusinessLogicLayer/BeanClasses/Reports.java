package BusinessLogicLayer.BeanClasses;

public class Reports {
  private int reportId;
  private String doctorId;
  private String patientId;
  private String diagnosisName;
  private String date;
  private String testResult;
  private String testType;

  public int getReportId() {
    return reportId;
  }

  public void setReportId(int reportId) {
    this.reportId = reportId;
  }

  public String getDoctorId() {
    return doctorId;
  }

  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getDiagnosisName() {
    return diagnosisName;
  }

  public void setDiagnosisName(String diagnosisName) {
    this.diagnosisName = diagnosisName;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTestResult() {
    return testResult;
  }

  public void setTestResult(String testResult) {
    this.testResult = testResult;
  }

  public String getTestType() {
    return testType;
  }

  public void setTestType(String testType) {
    this.testType = testType;
  }

}
