/*
 * CSCI 5308 Group Project
 * @author: Kishan Kahodariya
 * @description: This is a bean class for Appointments that
 * handles all parameters regarding an appointment throughout the
 * system.
 *
 * */

package BusinessLogicLayer.BeanClasses;

public class PatientAppointmentWithDoctor {

  private String patientName = null;
  private String doctorName = null;
  private String appointmentDate = null;
  private String timeSlot = null;
  private String typeOfAppointment = null;

  public PatientAppointmentWithDoctor(String patientName, String doctorName, String appointmentDate, String timeSlot, String typeOfAppointment) {
    this.patientName = patientName;
    this.doctorName = doctorName;
    this.appointmentDate = appointmentDate;
    this.timeSlot = timeSlot;
    this.typeOfAppointment = typeOfAppointment;
  }

  public PatientAppointmentWithDoctor() {
  }

  public String getPatientName() {
    return patientName;
  }

  public Boolean setPatientName(String patientName) {
    this.patientName = patientName;
    return true;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public Boolean setDoctorName(String doctorName) {
    this.doctorName = doctorName;
    return true;
  }

  public String getAppointmentDate() {
    return appointmentDate;
  }

  public Boolean setAppointmentDate(String appointmentDate) {
    this.appointmentDate = appointmentDate;
    return true;
  }

  public String getTimeSlot() {
    return timeSlot;
  }

  public Boolean setTimeSlot(String timeSlot) {
    this.timeSlot = timeSlot;
    return true;
  }

  public String getTypeOfAppointment() {
    return typeOfAppointment;
  }

  public Boolean setTypeOfAppointment(String typeOfAppointment) {
    this.typeOfAppointment = typeOfAppointment;
    return true;
  }
}
