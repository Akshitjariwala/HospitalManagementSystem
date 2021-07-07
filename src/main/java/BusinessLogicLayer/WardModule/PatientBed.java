package BusinessLogicLayer.WardModule;

public class PatientBed {

  private String patientName;
  private String bedCode;
  private String wardName;
  private String bedType;
  private int bedId;
  private String patientId;

  public PatientBed() {

  }

  public PatientBed(String patientName, String bedCode, String wardName, String bedType, int bedId, String patientId) {
    this.patientName = patientName;
    this.bedCode = bedCode;
    this.wardName = wardName;
    this.bedType = bedType;
    this.bedId = bedId;
    this.patientId = patientId;
  }

  /**
   * Get patient name who is using bed
   *
   * @return name of patient occupied bed
   */
  public String getPatientName() {
    return "patientName";
  }

  /**
   * Set patient name
   *
   * @param patientName to be set with bed
   */
  public void setPatientName(String patientName) {
  }

  /**
   * Get code of current bed
   *
   * @return bed code
   */
  public String getBedCode() {
    return "bedCode";
  }

  /**
   * Set bed code
   *
   * @param bedCode to be set with bed
   */
  public void setBedCode(String bedCode) {
  }

  /**
   * Get type of bed
   *
   * @return bed type of this bed
   */
  public String getBedType() {
    return "bedType";
  }

  /**
   * Set type of bed
   *
   * @param bedType to be set with bed
   */
  public void setBedType(String bedType) {
  }

  /**
   * Get ward name under which this bed available
   *
   * @return name of ward
   */
  public String getWardName() {
    return "wardName";
  }

  /**
   * Set ward name
   *
   * @param wardName to be set with bed
   */
  public void setWardName(String wardName) {
  }

  /**
   * Get patient id of patient who is using this bed
   *
   * @return patient id
   */
  public String getPatientId() {
    return "patientId";
  }

  /**
   * Set patient id
   *
   * @param patientId of patient
   */
  public void setPatientId(String patientId) {
  }

  /**
   * Get this bed id
   *
   * @return bed id
   */
  public int getBedId() {
    return -1;
  }

  /**
   * Set bed id
   *
   * @param bedId to be set for this bed
   */
  public void setBedId(int bedId) {
  }

}