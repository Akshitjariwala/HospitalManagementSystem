package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Login.IPatientLoginDAO;

public interface IPatientActionDatabase {

  IBookAppointmentsDAO getAppointmentDAO();
}
