/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This program handles login process of patients i.e.
 * it verifies if a patient is registered in the system or not.
 * The database access is done using common DatabaseConnection class
 *
 * */
package BusinessLogicLayer.BeanClasses;

public class Patient {

  private String firstName;
  private String lastName;
  private String middleName;
  private String emaiID;
  private String phoneNumber;
  private String address;
  private String cityName;
  private String stateName;
  private String emergencyContactName;
  private String emergencyContactNumber;
  private String userID = null;
  private String password = null;

  public Patient(String firstName, String lastName, String middleName, String emaiID, String phoneNumber, String address, String cityName, String stateName, String emergencyContactName, String emergencyContactNumber, String userID, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = middleName;
    this.emaiID = emaiID;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.cityName = cityName;
    this.stateName = stateName;
    this.emergencyContactName = emergencyContactName;
    this.emergencyContactNumber = emergencyContactNumber;
    this.userID = userID;
    this.password = password;
  }

  public Patient() {

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getEmaiID() {
    return emaiID;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public String getCityName() {
    return cityName;
  }

  public String getStateName() {
    return stateName;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public String getEmergencyContactNumber() {
    return emergencyContactNumber;
  }

  public String getUserID() {
    return userID;
  }

  public String getPassword() {
    return password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setMiddleName(String middleName) {
    if (middleName.equals(""))
      this.middleName = null;
    else
      this.middleName = middleName;
  }

  public void setEmaiID(String emaiID) {
    this.emaiID = emaiID;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setAddress(String address) {
    if (address.equals(""))
      this.address = null;
    else
      this.address = address;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public void setEmergencyContactName(String emergencyContactName) {
    if (emergencyContactName.equals(""))
      this.emergencyContactName = null;
    else
      this.emergencyContactName = emergencyContactName;
  }

  public void setEmergencyContactNumber(String emergencyContactNumber) {
    if (emergencyContactNumber.equals(""))
      this.emergencyContactNumber = null;
    else
      this.emergencyContactNumber = emergencyContactNumber;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
