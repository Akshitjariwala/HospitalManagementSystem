package DatabaseLayer.ActionDatabase.Doctor;

import DatabaseLayer.ActionDatabase.Doctor.ViewAppointments.IViewAppointmentsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewPatients.IViewPatientsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.IViewReportsDao;

public interface IDoctorActionDatabase {

  IViewAppointmentsDao viewAppointmentsDao();

  IViewPatientsDao viewPatientsDao();

  IViewReportsDao viewReportsDAO();
}
