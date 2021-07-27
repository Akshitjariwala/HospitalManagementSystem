package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Patient.Login.PatientLoginDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PatientLoginDAOTest {

  PatientLoginDAO patientLoginDAO;
  PatientRegistrationDAO patientRegistrationDAO;

  @BeforeEach
  void setup() {
    patientLoginDAO = Mockito.mock(PatientLoginDAO.class);
    patientRegistrationDAO = Mockito.mock(PatientRegistrationDAO.class);
  }

  @Test
  public void getLoginCredentialsTest() {

    Patient patient = new Patient("Kishan", "Patel", "", "kishan@gmail.ca", "88877645676", "", "halifax", "NS", "", "", "User2409", "Qawsed@2134");
    Mockito.when(patientRegistrationDAO.savePatientDetails(patient)).thenReturn(1);
    String providedPassword = "Qawsed@2134";
    Mockito.when(patientLoginDAO.getLoginCredentials("User2409")).thenReturn(providedPassword);
    assertEquals("Qawsed@2134", providedPassword);
  }

  @Test
  public void getPatientNameTest() {

    Patient patient = new Patient("Kishan", "Patel", "", "kishan@gmail.ca", "88877645676", "", "halifax", "NS", "", "", "User2409", "Qawsed@2134");
    Mockito.when(patientRegistrationDAO.savePatientDetails(patient)).thenReturn(1);
    String username = "Kishan Patel";
    Mockito.when(patientLoginDAO.getPatientName("User2409")).thenReturn(username);
    assertEquals("Kishan Patel", username);
  }
}
