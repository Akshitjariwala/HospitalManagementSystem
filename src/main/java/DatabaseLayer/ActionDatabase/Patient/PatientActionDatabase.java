package DatabaseLayer.ActionDatabase.Patient;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.BookAppointments.IBookAppointmentsDAO;
import DatabaseLayer.ActionDatabase.Patient.Login.IPatientLoginDAO;
import DatabaseLayer.ActionDatabase.Patient.Login.PatientLoginDAO;

public class PatientActionDatabase implements IPatientActionDatabase {

  @Override
  public IBookAppointmentsDAO getAppointmentDAO() {
    return new BookAppointmentsDAO();
  }

}
