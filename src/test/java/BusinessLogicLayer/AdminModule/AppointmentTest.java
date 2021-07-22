package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Appointment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppointmentTest {

  @Test
  void getAppointmentIdTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals(1, appointment.getAppointmentId(), "Appointment Id is not matching");
  }

  @Test
  void setAppointmentIdTest() {
    Appointment appointment = new Appointment();
    appointment.setAppointmentId(1);
    assertEquals(1, appointment.getAppointmentId(), "Appointment Id is not matching");
  }

  @Test
  void getPatientIdTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("joe999", appointment.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void setPatientIdTest() {
    Appointment appointment = new Appointment();
    appointment.setPatientId("joe999");
    assertEquals("joe999", appointment.getPatientId(), "Patient Id is not matching");
  }

  @Test
  void getDoctorIdTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("janki123", appointment.getDoctorId(), "Doctor Id is not matching");
  }

  @Test
  void setDoctorIdTest() {
    Appointment appointment = new Appointment();
    appointment.setDoctorId("janki123");
    assertEquals("janki123", appointment.getDoctorId(), "Doctor Id is not matching");
  }

  @Test
  void getAppointmentDateTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("08/07/2021", appointment.getDate(), "Appointment Date is not matching");
  }

  @Test
  void setAppointmentDateTest() {
    Appointment appointment = new Appointment();
    appointment.setDate("08/07/2021");
    assertEquals("08/07/2021", appointment.getDate(), "Appointment Date is not matching");
  }

  @Test
  void getPreferredSlotTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("Morning", appointment.getPreferredSlot(), "Appointment Preferred Slot is not matching");
  }

  @Test
  void setPreferredSlotTest() {
    Appointment appointment = new Appointment();
    appointment.setPreferredSlot("Morning");
    assertEquals("Morning", appointment.getPreferredSlot(), "Appointment Preferred Slot is not matching");
  }

  @Test
  void getAppointmentTypeTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("In Person", appointment.getTypeOfAppointment(), "Appointment Preferred Slot is not matching");
  }

  @Test
  void setAppointmentTypeTest() {
    Appointment appointment = new Appointment();
    appointment.setTypeOfAppointment("In Person");
    assertEquals("In Person", appointment.getTypeOfAppointment(), "Appointment Preferred Slot is not matching");
  }

  @Test
  void getAppointmentStatusTest() {
    Appointment appointment = new Appointment(1, "joe999", "janki123", "08/07/2021", "Morning", "In Person", "Pending");
    assertEquals("Pending", appointment.getAppointmentStatus(), "Appointment Preferred Slot is not matching");
  }

  @Test
  void setAppointmentStatusTest() {
    Appointment appointment = new Appointment();
    appointment.setAppointmentStatus("Pending");
    assertEquals("Pending", appointment.getAppointmentStatus(), "Appointment Preferred Slot is not matching");
  }
}