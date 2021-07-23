package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterDoctorDAOTest {

  @Test
  void addDoctor() {
    Doctor doc = new Doctor();

    doc.setFirstName("Test1");
    doc.setMiddleName("Test2");
    doc.setLastName("Test3");
    doc.setAddress("Colony");
    doc.setCity("City");
    doc.setExperience("2");
    doc.setDepartment("Department");
    doc.setEmailId("email@email");
    doc.setPassword("password");
    doc.setMedicalLicenseId("12345");
    doc.setSpecialization("cardio");
    doc.setState("State");
    doc.setPhoneNumber("999999999");


    assertEquals("Test1" + " " + "Test2" + " " + "Test3" + " " + "Colony" + " " + "City" + " " +
            "2" + " " + "Department" + " " + "email@email" + " " + "password" + " " + "12345" + " " + "cardio" + " " +
            "State" + " " + "999999999", doc.getFirstName() + " " + doc.getMiddleName() + " " + doc.getLastName() + " " +
            doc.getAddress() + " " + doc.getCity() + " " + doc.getExperience() + " " + doc.getDepartment() + " " +
            doc.getEmailId() + " " + doc.getPassword() + " " + doc.getMedicalLicenseId() + " " + doc.getSpecialization() + " " +
            doc.getState() + " " + doc.getPhoneNumber(), "Test Failed!. Incorrect or No value received.");

  }

  @Test
  void updateDoctor() {
    Doctor doc = new Doctor();
    doc.setFirstName("Test1");
    doc.setMiddleName("Test2");
    doc.setLastName("Test3");
    doc.setAddress("Colony");
    doc.setCity("City");
    doc.setExperience("2");
    doc.setDepartment("Department");
    doc.setEmailId("email@email");
    doc.setPassword("password");
    doc.setMedicalLicenseId("12345");
    doc.setSpecialization("cardio");
    doc.setState("State");
    doc.setPhoneNumber("999999999");


    assertEquals("Test1" + " " + "Test2" + " " + "Test3" + " " + "Colony" + " " + "City" + " " +
            "2" + " " + "Department" + " " + "email@email" + " " + "password" + " " + "12345" + " " + "cardio" + " " +
            "State" + " " + "999999999", doc.getFirstName() + " " + doc.getMiddleName() + " " + doc.getLastName() + " " +
            doc.getAddress() + " " + doc.getCity() + " " + doc.getExperience() + " " + doc.getDepartment() + " " +
            doc.getEmailId() + " " + doc.getPassword() + " " + doc.getMedicalLicenseId() + " " + doc.getSpecialization() + " " +
            doc.getState() + " " + doc.getPhoneNumber(), "Test Failed!. Incorrect or No value received.");

  }
}