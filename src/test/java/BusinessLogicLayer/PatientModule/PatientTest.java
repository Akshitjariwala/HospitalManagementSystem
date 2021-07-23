package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.BeanClasses.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

  @Test
  public void getFirstNameTest() {
    Patient patient = new Patient();
    patient.setFirstName("Kishan");
    assertEquals("Kishan", patient.getFirstName(), "getFirstNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getLastNameTest() {
    Patient patient = new Patient();
    patient.setLastName("Patel");
    assertEquals("Patel", patient.getLastName(), "getLastNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getMiddleNameTest() {
    Patient patient = new Patient();
    patient.setMiddleName("Mahesh");
    assertEquals("Mahesh", patient.getMiddleName(), "getMiddleNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getEmaiIDTest() {
    Patient patient = new Patient();
    patient.setEmaiID("user123@gmail.com");
    assertEquals("user123@gmail.com", patient.getEmaiID(), "getEmaiIDTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getPhoneNumberTest() {
    Patient patient = new Patient();
    patient.setPhoneNumber("3344555443");
    assertEquals("3344555443", patient.getPhoneNumber(), "getPhoneNumberTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getAddressTest() {
    Patient patient = new Patient();
    patient.setAddress("24 harbour View");
    assertEquals("24 harbour View", patient.getAddress(), "getAddressTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getCityNameTest() {
    Patient patient = new Patient();
    patient.setCityName("mumbai");
    assertEquals("mumbai", patient.getCityName(), "getCityNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getStateNameTest() {
    Patient patient = new Patient();
    patient.setStateName("Nova Scotia");
    assertEquals("Nova Scotia", patient.getStateName(), "getStateNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getEmergencyContactNameTest() {
    Patient patient = new Patient();
    patient.setEmergencyContactName("lily");
    assertEquals("lily", patient.getEmergencyContactName(), "getEmergencyContactNameTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getEmergencyContactNumberTest() {
    Patient patient = new Patient();
    patient.setEmergencyContactNumber("1122333221");
    assertEquals("1122333221", patient.getEmergencyContactNumber(), "getEmergencyContactNumberTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getUserIDTest() {
    Patient patient = new Patient();
    patient.setUserID("User2409");
    assertEquals("User2409", patient.getUserID(), "getUserIDTest Failed : Incorrect value or False value received ! ! !");
  }

  @Test
  public void getPasswordTest() {
    Patient patient = new Patient();
    patient.setPassword("Passwors@123");
    assertEquals("Passwors@123", patient.getPassword(), "getPasswordTest Failed : Incorrect value or False value received ! ! !");
  }


}
