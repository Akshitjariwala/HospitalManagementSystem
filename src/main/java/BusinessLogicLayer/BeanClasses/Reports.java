package BusinessLogicLayer.BeanClasses;

public class Reports {
    int reportId;
    int doctorId;
    String patientId;
    String diagnosisName;
    String date;
    String testResult;
    String testType;

    public int getReportId() {
        return reportId;
    }
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(int doctorId) {
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
