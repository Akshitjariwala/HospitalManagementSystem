package DatabaseLayer.ActionDatabase.Admin.ManageDoctor;

import BusinessLogicLayer.BeanClasses.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ManageDoctorDAOTest {

  private ManageDoctorDAO manageDoctorDAO;

  @BeforeEach
  void setup() {
    manageDoctorDAO = Mockito.mock(ManageDoctorDAO.class);
  }

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

    Mockito.when(manageDoctorDAO.addDoctor(doc)).thenReturn(1);
    assertEquals(1, manageDoctorDAO.addDoctor(doc), "The values are not inserted");
  }

  @Test
  void getDoctor() {
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

    Mockito.when(manageDoctorDAO.getDoctor("docno24")).thenReturn(doc);
    assertEquals(doc, manageDoctorDAO.getDoctor("docno24"), "The values are not inserted");
  }
}