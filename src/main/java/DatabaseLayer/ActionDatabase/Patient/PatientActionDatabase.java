package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;

public class PatientActionDatabase implements IPatientActionDatabase {

  @Override
  public IBookAppointmentsDAO getAppointmentDAO() {
    return new BookAppointmentsDAO();
  }
}
