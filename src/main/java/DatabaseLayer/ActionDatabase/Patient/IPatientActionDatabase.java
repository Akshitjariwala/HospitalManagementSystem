package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;

public interface IPatientActionDatabase {

  IBookAppointmentsDAO getAppointmentDAO();
}
