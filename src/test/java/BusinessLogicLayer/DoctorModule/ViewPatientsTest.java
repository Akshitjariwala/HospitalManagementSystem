package BusinessLogicLayer.DoctorModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewPatientsTest {

  private ViewPatients viewPatients;

  @BeforeEach
  void setup() {
    viewPatients = Mockito.mock(ViewPatients.class);
  }

  @Test
  void test_viewPatientWhenExists() {
    ViewPatients vp1 = new ViewPatients(1);
    boolean flag = true;
    Mockito.when(viewPatients.viewAllPatients()).thenReturn(flag);
    assertEquals(true, flag);
  }


  @Test
  void test_viewPatientNotExists() {
    ViewPatients vp1 = new ViewPatients(1);
    boolean flag = false;
    Mockito.when(viewPatients.viewAllPatients()).thenReturn(flag);
    assertEquals(false, flag);
  }

}
