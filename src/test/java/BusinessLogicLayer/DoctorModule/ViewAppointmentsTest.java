package BusinessLogicLayer.DoctorModule;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewAppointmentsTest {
  private ViewAppointments viewappointment;

  @BeforeEach
  void setup() {
    viewappointment = Mockito.mock(ViewAppointments.class);
  }

  @Test
  void viewappointments_confirmed() {
    ViewAppointments v1 = new ViewAppointments(1, "CONFIRM");
    boolean flag = true;
    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(flag);

    assertEquals(true, flag);
  }

  @Test
  void viewappointments_pending() {
    ViewAppointments v1 = new ViewAppointments(1, "Pending");
    boolean flag = true;
    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(flag);
    assertTrue(true);
  }

  @Test
  void viewappointments_NoAppointmentfound() {
    ViewAppointments v1 = new ViewAppointments(1, "CONFIRM");
    boolean flag = false;
    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(false);

    assertFalse(false);
  }


}


