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

    public Patient(String firstName, String lastName, String middleName, String emaiID, String phoneNumber, String address, String cityName, String stateName, String emergencyContactName, String emergencyContactNumber, String userID, String password, Scanner readInput) {
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
        this.readInput = readInput;
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

    public Scanner getReadInput() {
        return readInput;
    }

    public String setFirstName() {
        firstName=readInput.nextLine();
        return firstName;
    }

    public String setLastName() {
        lastName=readInput.nextLine();
        return lastName;
    }

    public String setMiddleName() {
        middleName=readInput.nextLine();
        return middleName;
    }

    public String setEmaiID() {
        emaiID=readInput.nextLine();
        return emaiID;
    }

    public String setPhoneNumber() {
        phoneNumber=readInput.nextLine();
        return phoneNumber;
    }

    public String setAddress() {
        address=readInput.nextLine();
        return address;
    }

    public String setCityName() {
        cityName=readInput.nextLine();
        return cityName;
    }

    public String setStateName() {
        stateName=readInput.nextLine();
        return stateName;
    }

    public String setEmergencyContactName() {
        emergencyContactName=readInput.nextLine();
        return emergencyContactName;
    }

    public String setEmergencyContactNumber() {
        emergencyContactNumber=readInput.nextLine();
        return emergencyContactNumber;
    }

    public String setUserID() {
        userID=readInput.nextLine();
        return userID;
    }

    public String setPassword() {
        password=readInput.nextLine();
        return password;
    }
}
