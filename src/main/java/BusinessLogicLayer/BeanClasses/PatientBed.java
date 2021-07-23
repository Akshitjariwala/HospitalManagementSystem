package BusinessLogicLayer.BeanClasses;

public class PatientBed {

  private String patientName;
  private Bed bed;
  private String patientId;

  public PatientBed() {

  }

  public PatientBed(String patientName, Bed bed, String patientId) {
    this.patientName = patientName;
    this.bed = bed;
    this.patientId = patientId;
  }

  /**
   * Get patient name who is using bed
   *
   * @return name of patient occupied bed
   */
  public String getPatientName() {
    return this.patientName;
  }

  /**
   * Set patient name
   *
   * @param patientName to be set with bed
   */
  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  /**
   * Get current bed
   *
   * @return bed
   */
  public Bed getBed() {
    return this.bed;
  }

  /**
   * Set bed
   *
   * @param bed to be set with patient
   */
  public void setBed(Bed bed) {
    this.bed = bed;
  }


  /**
   * Get patient id of patient who is using this bed
   *
   * @return patient id
   */
  public String getPatientId() {
    return this.patientId;
  }

  /**
   * Set patient id
   *
   * @param patientId of patient
   */
  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

}
