package BusinessLogicLayer.BeanClasses;

public class Bed {

  private int bedId;
  private String bedCode;
  private Ward ward;
  private boolean isOccupied;
  private String bedType;

  public Bed() {

  }

  public Bed(int bedId, String bedCode, Ward ward, boolean isOccupied, String bedType) {
    this.bedId = bedId;
    this.bedCode = bedCode;
    this.ward = ward;
    this.isOccupied = isOccupied;
    this.bedType = bedType;
  }

  /**
   * Get id of bed
   *
   * @return bedId
   */
  public int getBedId() {
    return this.bedId;
  }

  /**
   * Set bed is
   *
   * @param bedId to be set
   */
  public void setBedId(int bedId) {
    this.bedId = bedId;
  }

  /**
   * Get code of bed
   *
   * @return bedCode
   */
  public String getBedCode() {
    return this.bedCode;
  }

  /**
   * Set bed code
   *
   * @param bedCode to be set
   */
  public void setBedCode(String bedCode) {
    this.bedCode = bedCode;
  }

  /**
   * Get ward of this bed
   *
   * @return ward
   */
  public Ward getWard() {
    return this.ward;
  }

  /**
   * Set ward for bed
   *
   * @param ward - to be set
   */
  public void setWard(Ward ward) {
    this.ward = ward;
  }

  /**
   * Check if bed is occupied or not
   *
   * @return true if occupied, false other wise
   */
  public boolean getOccupied() {
    return this.isOccupied;
  }

  /**
   * Set bed as occupied or release bed
   *
   * @param isOccupied - true if wants to occupied
   */
  public void setOccupied(boolean isOccupied) {
    this.isOccupied = isOccupied;
  }

  /**
   * Get type of bed
   *
   * @return bedType
   */
  public String getBedType() {
    return this.bedType;
  }

  /**
   * Set type of bed
   *
   * @param bedType - type of bed
   */
  public void setBedType(String bedType) {
    this.bedType = bedType;
  }
}
