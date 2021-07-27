package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class BookAppointmentsDAOTest {

  BookAppointmentsDAO bookAppointmentsDAO;
  PatientRegistrationDAO patientRegistrationDAO;

  @BeforeEach
  void setup() {
    bookAppointmentsDAO = Mockito.mock(BookAppointmentsDAO.class);
    patientRegistrationDAO = Mockito.mock(PatientRegistrationDAO.class);
  }

  @Test
  public void getPatientNameTest() {

    Patient patient = new Patient("Kishan", "Patel", "", "kishan@gmail.ca", "88877645676", "", "halifax", "NS", "", "", "User2409", "Qawsed@2134");

    Mockito.when(patientRegistrationDAO.savePatientDetails(patient)).thenReturn(1);
    String name = "Kishan Patel";
    Mockito.when(bookAppointmentsDAO.getPatientName("User2409")).thenReturn(name);
    assertEquals("Kishan Patel", name);
  }

}
