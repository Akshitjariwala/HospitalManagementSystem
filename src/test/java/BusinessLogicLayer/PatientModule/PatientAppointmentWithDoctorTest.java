package BusinessLogicLayer.PatientModule;

import BusinessLogicLayer.BeanClasses.PatientAppointmentWithDoctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientAppointmentWithDoctorTest {

  @Test
  public void getPatientNameTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor("kishan", "Dr.Paresh Sheikh", "05/07/2021", "morning", "In Person");
    assertEquals("kishan", patientAppointmentWithDoctor.getPatientName());
  }

  @Test
  public void getDoctorNameTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor("kishan", "Dr.Paresh Sheikh", "05/07/2021", "morning", "In Person");
    assertEquals("Dr.Paresh Sheikh", patientAppointmentWithDoctor.getDoctorName());
  }

  @Test
  public void getAppointmentDateTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor("kishan", "Dr.Paresh Sheikh", "05/07/2021", "morning", "In Person");
    assertEquals("05/07/2021", patientAppointmentWithDoctor.getAppointmentDate());
  }

  @Test
  public void getTimeSlotTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor("kishan", "Dr.Paresh Sheikh", "05/07/2021", "morning", "In Person");
    assertEquals("morning", patientAppointmentWithDoctor.getTimeSlot());
  }

  @Test
  public void getTypeOfAppointmentTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor("kishan", "Dr.Paresh Sheikh", "05/07/2021", "morning", "In Person");
    assertEquals("In Person", patientAppointmentWithDoctor.getTypeOfAppointment());
  }

  @Test
  public void setPatientNameTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor();
    assertTrue(patientAppointmentWithDoctor.setPatientName("kishan"));
  }

  @Test
  public void setDoctorNameTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor();
    assertTrue(patientAppointmentWithDoctor.setDoctorName("Dr.Paresh Sheikh"));
  }

  @Test
  public void setAppointmentDateTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor();
    assertTrue(patientAppointmentWithDoctor.setAppointmentDate("05/07/2021"));
  }

  @Test
  public void setTimeSlotTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor();
    assertTrue(patientAppointmentWithDoctor.setTimeSlot("morning"));
  }

  @Test
  public void setTypeOfAppointmentTest() {
    PatientAppointmentWithDoctor patientAppointmentWithDoctor = new PatientAppointmentWithDoctor();
    assertTrue(patientAppointmentWithDoctor.setTypeOfAppointment("In person"));
  }


}
