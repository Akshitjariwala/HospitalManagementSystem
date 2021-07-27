package BusinessLogicLayer.BeanClasses;

import java.sql.Date;

public class Admission {

  private int admissionID;
  private String patientID;
  private int admissionType;
  private int wardID;
  private int bedID;
  private int doctorID;
  private int diseaseID;
  private Date admissionDate;
  private Date dischargeDate;
  private String dischargeComment;

  public Admission() {
  }

  public Admission(String patientID, int admissionType, int wardID, int bedID, int doctorID, int diseaseID) {
    this.patientID = patientID;
    this.admissionType = admissionType;
    this.wardID = wardID;
    this.bedID = bedID;
    this.doctorID = doctorID;
    this.diseaseID = diseaseID;
  }

  public Date getAdmissionDate() {
    return admissionDate;
  }

  public void setAdmissionDate(Date admissionDate) {
    this.admissionDate = admissionDate;
  }

  public Date getDischargeDate() {
    return dischargeDate;
  }

  public void setDischargeDate(Date dischargeDate) {
    this.dischargeDate = dischargeDate;
  }

  public String getDischargeComment() {
    return dischargeComment;
  }

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

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public int getAdmissionType() {
    return this.admissionType;
  }

  public void setAdmissionType(int admissionType) {
    this.admissionType = admissionType;
  }

  public int getWardID() {
    return this.wardID;
  }

  public void setWardID(int wardID) {
    this.wardID = wardID;
  }

  public int getBedID() {
    return this.bedID;
  }

  public void setBedID(int bedID) {
    this.bedID = bedID;
  }

  public int getDoctorID() {
    return this.doctorID;
  }

  public void setDoctorID(int doctorID) {
    this.doctorID = doctorID;
  }

  public int getDiseaseID() {
    return this.diseaseID;
  }

  public void setDiseaseID(int diseaseID) {
    this.diseaseID = diseaseID;
  }

}
