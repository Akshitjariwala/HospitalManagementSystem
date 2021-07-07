package BusinessLogicLayer.WardModule;

public class Bed {
  private String bedCode;
  private int wardId;
  private boolean isOccupied;
  private String bedType;

  public Bed() {

  }

  public Bed(String bedCode, int wardId, boolean isOccupied, String bedType) {
    this.bedCode = bedCode;
    this.wardId = wardId;
    this.isOccupied = isOccupied;
    this.bedType = bedType;
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
   * Get ward id of bed
   *
   * @return wardId
   */
  public int getWardId() {
    return this.wardId;
  }

  /**
   * Set ward id for bed
   *
   * @param wardId - to be set
   */
  public void setWardId(int wardId) {
    this.wardId = wardId;
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
