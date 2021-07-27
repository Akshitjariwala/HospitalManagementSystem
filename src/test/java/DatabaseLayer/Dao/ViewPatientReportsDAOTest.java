package DatabaseLayer.Dao;

import DatabaseLayer.ActionDatabase.Patient.ViewReports.ViewPatientReportsDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ViewPatientReportsDAOTest {

  ViewPatientReportsDAO viewPatientReportsDAO;
  ResultSet resultSet;

  @BeforeEach
  void setup() {
    viewPatientReportsDAO = Mockito.mock(ViewPatientReportsDAO.class);
    resultSet = Mockito.mock(ResultSet.class);
  }

  @Test
  public void fetchLabReports() throws SQLException {

    Mockito.when(viewPatientReportsDAO.fetchLabReports("User2409")).thenReturn(resultSet);
    assertEquals(0, resultSet.getRow());
  }
}
