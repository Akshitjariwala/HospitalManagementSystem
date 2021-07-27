package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Login.IPatientLoginDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.IPatientRegistrationDAO;

public interface IPatientActionDatabase {

  IBookAppointmentsDAO getAppointmentDAO();

  IPatientRegistrationDAO registerPatient();
}
