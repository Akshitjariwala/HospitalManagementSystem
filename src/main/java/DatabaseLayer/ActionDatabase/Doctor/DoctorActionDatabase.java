package DatabaseLayer.ActionDatabase.Doctor;

import DatabaseLayer.ActionDatabase.Doctor.ViewAppointments.IViewAppointmentsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewAppointments.ViewAppointmentsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewPatients.IViewPatientsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewPatients.ViewPatientsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.IViewReportsDao;
import DatabaseLayer.ActionDatabase.Doctor.ViewReports.ViewReportsDao;

public class DoctorActionDatabase implements IDoctorActionDatabase {



	@Override
	public IViewAppointmentsDao viewAppointmentsDao() {
		// TODO Auto-generated method stub
		return new ViewAppointmentsDao() ;
	}

	@Override
	public IViewPatientsDao viewPatientsDao() {
		// TODO Auto-generated method stub
		return new ViewPatientsDao();
	}

	@Override
	public IViewReportsDao viewReportsDAO() {
		// TODO Auto-generated method stub
		return new ViewReportsDao();
	}

}
