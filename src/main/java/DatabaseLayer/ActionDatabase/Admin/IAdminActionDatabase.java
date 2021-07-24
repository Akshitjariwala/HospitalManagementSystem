package DatabaseLayer.ActionDatabase.Admin;

import DatabaseLayer.ActionDatabase.Admin.Appointments.IAppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.IWardDAO;

public interface IAdminActionDatabase {

  IWardDAO manageWard();

  IBedDAO manageBed();

  IAdmissionDischargeDatabase admissionDischarge();

  IAppointmentDAO manageAppointments();
}
