package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.IPatientRegistrationDAO;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;
import DatabaseLayer.ActionDatabase.Patient.ViewReports.IViewPatientReportsDAO;
import DatabaseLayer.ActionDatabase.Patient.ViewReports.ViewPatientReportsDAO;

public class PatientActionDatabase implements IPatientActionDatabase {

  @Override
  public IBookAppointmentsDAO getAppointmentDAO() {
    return new BookAppointmentsDAO();
  }

  @Override
  public IPatientRegistrationDAO registerPatientDAO() {
    return new PatientRegistrationDAO();
  }

  @Override
  public IViewPatientReportsDAO viewReportsDAO() {
    return new ViewPatientReportsDAO();
  }

}
