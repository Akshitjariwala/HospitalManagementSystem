package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.BeanClasses.Appointment;

import java.util.List;

public interface IManageAppointmentDatabase {

  List<Appointment> getAppointmentList();

  boolean updateAppointmentStatus(int appId, String newStatus);

}
