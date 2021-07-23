package BusinessLogicLayer.BeanClasses;

public class Ward {

  private int wardId;
  private String wardName;
  private String wardType;
  private String location;
  private int totalBeds;
  private String bedType;

  public Ward() {

  }

  public Ward(int wardId, String wardName, String wardType, String location, int totalBeds, String bedType) {
    this.wardId = wardId;
    this.wardName = wardName;
    this.wardType = wardType;
    this.location = location;
    this.totalBeds = totalBeds;
    this.bedType = bedType;
  }

  /**
   * Get unique id of the ward
   *
   * @return ward id
   */
  public int getWardId() {
    return this.wardId;
  }

  /**
   * Set ward id
   *
   * @param wardId to be set
   */
  public void setWardId(int wardId) {
    this.wardId = wardId;
  }

  /**
   * Get name of the ward
   *
   * @return wardName
   */
  public String getWardName() {
    return this.wardName;
  }

  /**
   * Set ward name
   *
   * @param wardName to be set
   */
  public void setWardName(String wardName) {
    this.wardName = wardName;
  }

  /**
   * Get ward type
   *
   * @return wardType
   */
  public String getWardType() {
    return this.wardType;
  }

  /**
   * Set ward type
   *
   * @param wardType - to be set
   */
  public void setWardType(String wardType) {
    this.wardType = wardType;
  }

  /**
   * Get ward location
   *
   * @return location of the ward
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * Set ward location
   *
   * @param location - ward location to be set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * Get type of bed in ward
   *
   * @return bedType of the given ward
   */
  public String getBedType() {
    return this.bedType;
  }

  /**
   * Set type of bed in ward
   *
   * @param bedType in ward
   */
  public void setBedType(String bedType) {
    this.bedType = bedType;
  }

  /**
   * Get total beds in ward
   *
   * @return number of beds
   */
  public int getTotalBeds() {
    return this.totalBeds;
  }

  /**
   * Set number of beds in ward
   *
   * @param totalBeds available in ward
   */
  public void setTotalBeds(int totalBeds) {
    this.totalBeds = totalBeds;
  }
}
