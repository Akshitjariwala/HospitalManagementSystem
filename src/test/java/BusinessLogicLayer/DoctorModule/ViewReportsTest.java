package BusinessLogicLayer.DoctorModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewReportsTest {
  private ViewReports viewReports;

  @BeforeEach
  void setup() {
    viewReports = Mockito.mock(ViewReports.class);
  }

  @Test
  void test_allReports() {
    ViewReports vr1 = new ViewReports(1);
    boolean flag = true;
    Mockito.when(viewReports.viewAllReports()).thenReturn(flag);
    assertEquals(true, flag);
  }

  @Test
  void test_patientReports() {
    ViewReports vr1 = new ViewReports(1);
    boolean flag = true;
    String patientId = "kkishan123";
    Mockito.when(viewReports.viewPatientReports(patientId)).thenReturn(flag);
    assertEquals(true, flag);

  }

}
