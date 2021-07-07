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
    return "bedCode";
  }

  /**
   * Set bed code
   *
   * @param bedCode to be set
   */
  public void setBedCode(String bedCode) {
  }

  /**
   * Get ward id of bed
   *
   * @return wardId
   */
  public int getWardId() {
    return 0;
  }

  /**
   * Set ward id for bed
   *
   * @param wardId - to be set
   */
  public void setWardId(int wardId) {
  }

  /**
   * Check if bed is occupied or not
   *
   * @return true if occupied, false other wise
   */
  public boolean getOccupied() {
    return false;
  }

  /**
   * Set bed as occupied or release bed
   *
   * @param isOccupied - true if wants to occupied
   */
  public void setOccupied(boolean isOccupied) {
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
   * @param bedType
   */
  public void setBedType(String bedType) {
    this.bedType = bedType;
  }
}
