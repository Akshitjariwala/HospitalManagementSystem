package BusinessLogicLayer.AdminModule;

public class Appointment {
  private int appointmentId;
  private String patientId;
  private String doctorId;
  private String date;
  private String preferredSlot;
  private String typeOfAppointment;
  private String appointmentStatus;

  public Appointment() {

  }

  public Appointment(int appointmentId, String patientId, String doctorId, String date, String preferredSlot, String typeOfAppointment, String appointmentStatus) {
    this.appointmentId = appointmentId;
    this.patientId = patientId;
    this.doctorId = doctorId;
    this.date = date;
    this.preferredSlot = preferredSlot;
    this.typeOfAppointment = typeOfAppointment;
    this.appointmentStatus = appointmentStatus;
  }

  /**
   * Get unique id of the appointment
   *
   * @return appointment id
   */
  public int getAppointmentId() {
    return -1;
  }

  /**
   * Set appointment id
   *
   * @param appointmentId to be set
   */
  public void setAppointmentId(int appointmentId) {
  }

  /**
   * Get id of patient
   *
   * @return patient id
   */
  public String getPatientId() {
    return "patientId";
  }

  /**
   * Set patient id for appointment
   *
   * @param patientId to be set
   */
  public void setPatientId(String patientId) {
  }

  /**
   * Get id of doctor you book appointment with
   *
   * @return doctor id
   */
  public String getDoctorId() {
    return "doctorId";
  }

  /**
   * Set doctor is, you want to book appointment with
   *
   * @param doctorId - to be set
   */
  public void setDoctorId(String doctorId) {
  }

  /**
   * Get appointment date
   *
   * @return appointment date
   */
  public String getDate() {
    return "01/01/2021";
  }

  /**
   * Set appointment date
   *
   * @param date - on which you want to book appointment
   */
  public void setDate(String date) {
  }

  /**
   * Get preferred slot of your appointment
   *
   * @return preferred slot
   */
  public String getPreferredSlot() {
    return "preferredSlot";
  }

  /**
   * Set preferred slot for appointment booking
   *
   * @param preferredSlot in ward
   */
  public void setPreferredSlot(String preferredSlot) {
  }

  /**
   * Get appointment type you booked
   *
   * @return type of appointment
   */
  public String getTypeOfAppointment() {
    return "typeOfAppointment";
  }

  /**
   * Set type of appointment in person or online consultation
   *
   * @param typeOfAppointment available for appointment
   */
  public void setTypeOfAppointment(String typeOfAppointment) {
  }

  /**
   * Get current appointment status
   *
   * @return appointment status
   */
  public String getAppointmentStatus() {
    return "appointmentStatus";
  }

  /**
   * Set new appointment status
   *
   * @param appointmentStatus for current appointment
   */
  public void setAppointmentStatus(String appointmentStatus) {
  }
}
