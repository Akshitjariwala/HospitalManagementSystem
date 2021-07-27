package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Appointment;

import java.util.List;

public interface IManageAppointments {

  void displayAppointments(List<Appointment> appointments);
}
