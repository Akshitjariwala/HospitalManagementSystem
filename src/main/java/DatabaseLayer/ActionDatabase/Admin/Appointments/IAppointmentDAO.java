package DatabaseLayer.ActionDatabase.Admin.Appointments;

import BusinessLogicLayer.BeanClasses.Appointment;

import java.util.List;

public interface IAppointmentDAO {

  List<Appointment> getAppointmentList();

  boolean updateAppointmentStatus(int appId, String newStatus);

}
