package BusinessLogicLayer.PatientModule.PatientInterfaces;

public interface IBookAppointments extends INewDetails {

  boolean appointmentBookingPortalofPatient(String patientid);

  void displayDoctorList();

  void saveEnteredDetails(String patient, String doctor);
}
