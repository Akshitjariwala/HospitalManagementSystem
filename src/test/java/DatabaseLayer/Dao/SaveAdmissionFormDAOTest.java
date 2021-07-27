package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.SaveAdmissionFormDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaveAdmissionFormDAOTest {

  public SaveAdmissionFormDAO saveAdmission;

  @BeforeEach
  void setup() {
    saveAdmission = Mockito.mock(SaveAdmissionFormDAO.class);
  }

  @Test
  void saveAdmissionForm() throws SQLException {
    Admission admission = new Admission("doe999", 1, 4, 5, 7, 6);
    Mockito.when(saveAdmission.saveAdmissionForm(admission)).thenReturn(1);
    assertEquals(1, saveAdmission.saveAdmissionForm(admission), "Test Failed!. Incorrect or No value received.");
  }

  @Test
  void updateAdmissionForm() throws SQLException {
    Admission admission = new Admission("doe999", 2, 3, 1, 3, 4);
    admission.setAdmissionID(50);
    Mockito.when(saveAdmission.updateAdmissionForm(admission)).thenReturn(1);
    assertEquals(1, saveAdmission.updateAdmissionForm(admission), "Test Failed!. Incorrect or No value received.");
  }
}