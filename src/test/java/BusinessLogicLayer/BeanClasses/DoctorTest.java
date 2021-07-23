package BusinessLogicLayer.BeanClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

  @Test
  void getFirstName() {
    Doctor doct = new Doctor();
    doct.setFirstName("Jupudi");
    assertEquals("Jupudi", doct.getFirstName(), "The name doesnt match");
  }

  @Test
  void setFirstName() {
    Doctor doct = new Doctor();
    doct.setFirstName("J");
    assertEquals("J", doct.getFirstName(), "The name doesnt match");
  }

  @Test
  void getMiddleName() {
    Doctor doct = new Doctor();
    doct.setMiddleName("testMiddle");
    assertEquals("testMiddle", doct.getMiddleName(), "The name doesnt match");
  }

  @Test
  void setMiddleName() {
    Doctor doct = new Doctor();
    doct.setMiddleName("testMiddle1");
    assertEquals("testMiddle1", doct.getMiddleName(), "The name doesnt match");
  }


  @Test
  void getLastName() {
    Doctor doct = new Doctor();
    doct.setLastName("testLastName");
    assertEquals("testLastName", doct.getLastName(), "The name doesnt match");
  }

  @Test
  void setLastName() {
    Doctor doct = new Doctor();
    doct.setLastName("testLastNameForSet");
    assertEquals("testLastNameForSet", doct.getLastName(), "The name doesnt match");
  }

  @Test
  void getPassword() {
    Doctor doct = new Doctor();
    doct.setPassword("testPassword");
    assertEquals("testPassword", doct.getPassword(), "The password doesnt match");
  }

  @Test
  void setPassword() {
    Doctor doct = new Doctor();
    doct.setPassword("testPasswordForSet");
    assertEquals("testPasswordForSet", doct.getPassword(), "The password doesnt match");
  }

  @Test
  void getEmailId() {
    Doctor doct = new Doctor();
    doct.setEmailId("vaishnavi@gmail.com");
    assertEquals("vaishnavi@gmail.com", doct.getEmailId(), "The email doesnt match");
  }

  @Test
  void setEmailId() {
    Doctor doct = new Doctor();
    doct.setEmailId("vaishnavi94@gmail.com");
    assertEquals("vaishnavi94@gmail.com", doct.getEmailId(), "The email doesnt match");
  }

  @Test
  void getMedicalLicenseId() {
    Doctor doct = new Doctor();
    doct.setMedicalLicenseId("223344AWP");
    assertEquals("223344AWP", doct.getMedicalLicenseId(), "The Id doesnt match");
  }

  @Test
  void setMedicalLicenseId() {
    Doctor doct = new Doctor();
    doct.setMedicalLicenseId("223344AWPB6");
    assertEquals("223344AWPB6", doct.getMedicalLicenseId(), "The Id doesnt match");
  }

  @Test
  void getSpecialization() {
    Doctor doct = new Doctor();
    doct.setSpecialization("Cardiology");
    assertEquals("Cardiology", doct.getSpecialization(), "The specialization doesnt match");
  }

  @Test
  void setSpecialization() {
    Doctor doct = new Doctor();
    doct.setSpecialization("dentist");
    assertEquals("dentist", doct.getSpecialization(), "The specialization doesnt match");
  }

  @Test
  void getDepartment() {
    Doctor doct = new Doctor();
    doct.setDepartment("Dentistry");
    assertEquals("Dentistry", doct.getDepartment(), "The department doesnt match");
  }

  @Test
  void setDepartment() {
    Doctor doct = new Doctor();
    doct.setDepartment("Pulmonology");
    assertEquals("Pulmonology", doct.getDepartment(), "The department doesnt match");
  }

  @Test
  void getExperience() {
    Doctor doct = new Doctor();
    doct.setExperience("3");
    assertEquals("3", doct.getExperience(), "The experience doesnt match");
  }

  @Test
  void setExperience() {
    Doctor doct = new Doctor();
    doct.setExperience("11");
    assertEquals("11", doct.getExperience(), "The experience doesnt match");
  }

  @Test
  void getAddress() {
    Doctor doct = new Doctor();
    doct.setAddress("Plot 86, RTA");
    assertEquals("Plot 86, RTA", doct.getAddress(), "The address doesnt match");
  }

  @Test
  void setAddress() {
    Doctor doct = new Doctor();
    doct.setAddress("Plot 86, RTA Office");
    assertEquals("Plot 86, RTA Office", doct.getAddress(), "The address doesnt match");
  }

  @Test
  void getCity() {
    Doctor doct = new Doctor();
    doct.setCity("Hyderabad");
    assertEquals("Hyderabad", doct.getCity(), "The city doesnt match");
  }

  @Test
  void setCity() {
    Doctor doct = new Doctor();
    doct.setCity("Vizag");
    assertEquals("Vizag", doct.getCity(), "The city doesnt match");
  }

  @Test
  void getState() {
    Doctor doct = new Doctor();
    doct.setState("Ap");
    assertEquals("Ap", doct.getState(), "The State doesnt match");
  }

  @Test
  void setState() {
    Doctor doct = new Doctor();
    doct.setState("Telangana");
    assertEquals("Telangana", doct.getState(), "The State doesnt match");
  }

  @Test
  void getPhoneNumber() {
    Doctor doct = new Doctor();
    doct.setPhoneNumber("9900990099");
    assertEquals("9900990099", doct.getPhoneNumber(), "The number doesnt match");
  }

  @Test
  void setPhoneNumber() {
    Doctor doct = new Doctor();
    doct.setPhoneNumber("88990099");
    assertEquals("88990099", doct.getPhoneNumber(), "The number doesnt match");
  }

  @Test
  void getId() {
    Doctor doct = new Doctor();
    int id = 1;
    doct.setId(id);
    assertEquals(1, doct.getId(), "The id doesnt match");
  }

  @Test
  void setId() {
    Doctor doct = new Doctor();
    int id = 1;
    doct.setId(id);
    assertEquals(1, doct.getId(), "The id doesnt match");
  }

  @Test
  void testToString() {

  }
}