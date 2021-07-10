package BusinessLogicLayer.PatientModule;

import java.util.Scanner;

public class Patient {
    private String firstName=null;
    private String lastName=null;
    private String middleName=null;
    private String emaiID=null;
    private String phoneNumber=null;
    private String address=null;
    private String cityName=null;
    private String stateName=null;
    private String emergencyContactName=null;
    private String emergencyContactNumber=null;
    private String userID=null;
    private String password=null;
    private Scanner readInput=new Scanner(System.in);

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
    public Patient(){

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
        if (middleName=="")
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
        if (address=="")
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
        if (emergencyContactName=="")
            this.emergencyContactName = null;
        else
            this.emergencyContactName = emergencyContactName;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        if (emergencyContactNumber=="")
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

    public void setReadInput(Scanner readInput) {
        this.readInput = readInput;
    }

}