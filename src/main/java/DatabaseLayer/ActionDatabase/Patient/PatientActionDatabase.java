package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.IPatientRegistrationDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;

public class PatientActionDatabase implements IPatientActionDatabase {

  @Override
  public IBookAppointmentsDAO getAppointmentDAO() {
    return new BookAppointmentsDAO();
  }

  @Override
  public IPatientRegistrationDAO registerPatient() {
    return new PatientRegistrationDAO();
  }

}
