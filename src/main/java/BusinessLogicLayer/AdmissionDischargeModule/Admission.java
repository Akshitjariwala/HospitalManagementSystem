package BusinessLogicLayer.AdmissionDischargeModule;

import java.time.LocalDate;

public class Admission {

  private int admissionID;
    private String patientID;
    private int admissionType;
    private int wardID;
    private int bedID;
    private int doctorID;
    private int diseaseID;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String dischargeComment;

    public Admission(){};

    public Admission(String patientID,int admissionType,int wardID,int bedID,int doctorID,int diseaseID){
        this.patientID = patientID;
        this.admissionType = admissionType;
        this.wardID = wardID;
        this.bedID = bedID;
        this.doctorID = doctorID;
        this.diseaseID = diseaseID;
    }


    // getAdmissionDate() returns the date of Admission.
    public LocalDate getAdmissionDate() {
      return admissionDate;
    }

    // setAdmissionDate() sets the date of Admission.
    public void setAdmissionDate(LocalDate admissionDate) {
      this.admissionDate = admissionDate;
    }

    // getDischargeDate() returns the date of Discharge.
    public LocalDate getDischargeDate() {
      return dischargeDate;
    }

    // setAdmissionDate() sets the date of Discharge.
    public void setDischargeDate(LocalDate dischargeDate) {
      this.dischargeDate = dischargeDate;
    }

    // getDischargeComment() returns Discharge comment.
    public String getDischargeComment() {
      return dischargeComment;
    }

    // setDischargeComment() sets Discharge comment.
    public void setDischargeComment(String dischargeComment) {
      this.dischargeComment = dischargeComment;
    }

    public int getAdmissionID() {
      return admissionID;
    }

    public void setAdmissionID(int admissionID) {
      this.admissionID = admissionID;
    }

    public String getPatientID() {
        return this.patientID;
    }
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public int getAdmissionType() {
        return this.admissionType;
    }
    public void setAdmissionType(int admissionType){
        this.admissionType = admissionType;
    }

    public int getWardID() {
        return this.wardID;
    }
    public void setWardID(int wardID){
        this.wardID = wardID;
    }

    public int getBedID() {
        return this.bedID;
    }
    public void setBedID(int bedID){
        this.bedID = bedID;
    }

    public int getDoctorID() {
        return this.doctorID;
    }
    public void setDoctorID(int doctorID){
        this.doctorID =doctorID;
    }

    public int getDiseaseID() {
        return this.diseaseID;
    }
    public void setDiseaseID(int diseaseID){
        this.diseaseID =diseaseID;
    }

}
