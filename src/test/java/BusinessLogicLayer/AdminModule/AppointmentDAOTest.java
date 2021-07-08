package BusinessLogicLayer.AdminModule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppointmentDAOTest {

  private AppointmentDAO appointmentDAO;

  @BeforeEach
  void setup() {
    appointmentDAO = Mockito.mock(AppointmentDAO.class);
  }

  @Test
  void getAppointmentListTest() {
    Appointment appointment1 = new Appointment(1, "joe999", "janki123", "09/07/2021", "Morning", "In Person", "Pending");
    Appointment appointment2 = new Appointment(2, "joe999", "janki123", "10/07/2021", "Morning", "In Person", "Pending");

    ArrayList<Appointment> appointments = new ArrayList<>(Arrays.asList(appointment1, appointment2));
    Mockito.when(appointmentDAO.getAppointmentList()).thenReturn(appointments);
    assertEquals(2, appointments.size());
  }

  @Test
  void updateAppointmentStatusTest() {
    Appointment appointment1 = new Appointment(1, "joe999", "janki123", "09/07/2021", "Morning", "In Person", "Pending");
    appointment1.setAppointmentStatus("Confirm");
    Mockito.when(appointmentDAO.updateAppointmentStatus(1, "Confirm")).thenReturn(true);
    assertTrue(appointmentDAO.updateAppointmentStatus(1, "Confirm"));
  }
}