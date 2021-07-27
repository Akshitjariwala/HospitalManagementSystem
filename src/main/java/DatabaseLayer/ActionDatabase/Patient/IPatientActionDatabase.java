package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.IPatientRegistrationDAO;
import DatabaseLayer.ActionDatabase.Patient.ViewReports.IViewPatientReportsDAO;

public interface IPatientActionDatabase {

  IBookAppointmentsDAO getAppointmentDAO();

  IPatientRegistrationDAO registerPatientDAO();

  IViewPatientReportsDAO viewReportsDAO();
}
