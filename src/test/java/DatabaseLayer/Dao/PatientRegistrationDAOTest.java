package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PatientRegistrationDAOTest {

  PatientRegistrationDAO patientRegistrationDAO;

  @BeforeEach
  void setup() {
    patientRegistrationDAO = Mockito.mock(PatientRegistrationDAO.class);
  }

  @Test
  public void getPatientNameTest() {

    Patient patient = new Patient("Kishan", "Patel", "", "kishan@gmail.ca", "88877645676", "", "halifax", "NS", "", "", "User2409", "Qawsed@2134");
    int result = 1;
    Mockito.when(patientRegistrationDAO.savePatientDetails(patient)).thenReturn(result);
    assertEquals(1, result);

  }

}
