package BusinessLogicLayer.PatientModule.PatientInterfaces;

public interface BookAppointmentsInterface extends NewDetailsInterface  {

     boolean appointmentBookingPortalofPatient(String patientid);
     void displayDoctorList();
}
