package BusinessLogicLayer.WardModule;

public class Ward {
  private String wardName;
  private String wardType;
  private String location;
  private int totalBeds;
  private String bedType;

  public Ward() {

  }

  public Ward(String wardName, String wardType, String location, int totalBeds, String bedType) {
    this.wardName = wardName;
    this.wardType = wardType;
    this.location = location;
    this.totalBeds = totalBeds;
    this.bedType = bedType;
  }

  /**
   * Get name of the ward
   *
   * @return wardName
   */
  public String getWardName() {
    return "wardName";
  }

  /**
   * Set ward name
   *
   * @param wardName to be set
   */
  public void setWardName(String wardName) {

  }

  /**
   * Get ward type
   *
   * @return wardType
   */
  public String getWardType() {
    return "wardType";
  }

  /**
   * Set ward type
   *
   * @param wardType - to be set
   */
  public void setWardType(String wardType) {
  }

  /**
   * Get ward location
   *
   * @return location of the ward
   */
  public String getLocation() {
    return "location";
  }

  /**
   * Set ward location
   *
   * @param location - ward location to be set
   */
  public void setLocation(String location) {
  }

  /**
   * Get type of bed in ward
   *
   * @return bedType of the given ward
   */
  public String getBedType() {
    return "bedType";
  }

  /**
   * Set type of bed in ward
   *
   * @param bedType in ward
   */
  public void setBedType(String bedType) {
  }

  /**
   * Get total beds in ward
   *
   * @return number of beds
   */
  public int getTotalBeds() {
    return 0;
  }

  /**
   * Set number of beds in ward
   *
   * @param totalBeds available in ward
   */
  public void setTotalBeds(int totalBeds) {
  }
}
