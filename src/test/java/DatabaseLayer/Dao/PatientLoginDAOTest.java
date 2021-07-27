package DatabaseLayer.Dao;

import DatabaseLayer.ActionDatabase.Patient.Login.PatientLoginDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientLoginDAOTest {

  @Test
  public void getLoginCredentialsTest() {

    PatientLoginDAO patientLoginDAO = new PatientLoginDAO();
    assertEquals("PAss@2345", patientLoginDAO.getLoginCredentials("User2409"));
  }

  @Test
  public void getPatientNameTest() {

    PatientLoginDAO patientLoginDAO = new PatientLoginDAO();
    assertEquals("Kishan Patel", patientLoginDAO.getPatientName("User2409"));
  }
}
