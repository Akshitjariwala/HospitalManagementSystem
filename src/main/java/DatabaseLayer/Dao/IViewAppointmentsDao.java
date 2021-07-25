package DatabaseLayer.Dao;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Appointment;

public interface IViewAppointmentsDao {
	List<Appointment> getAppointmentList(int docId, String status);
}
