package DatabaseLayer.ActionDatabase.Admin;

import BusinessLogicLayer.AdminModule.Appointment;

import java.util.ArrayList;

public interface IManageAppointmentDatabase {

  ArrayList<Appointment> getAppointmentList();

  boolean updateAppointmentStatus(int appId, String newStatus);

}
