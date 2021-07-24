package DatabaseLayer.ActionDatabase.Admin;

import DatabaseLayer.ActionDatabase.Admin.Appointments.AppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Appointments.IAppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.BedDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.IWardDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.WardDAO;

public class AdminActionDatabase implements IAdminActionDatabase {

  @Override
  public IWardDAO manageWard() {
    return new WardDAO();
  }

  @Override
  public IBedDAO manageBed() {
    return new BedDAO();
  }

  @Override
  public IAdmissionDischargeDatabase admissionDischarge() {
    return null;
  }

  @Override
  public IAppointmentDAO manageAppointments() {
    return new AppointmentDAO();
  }
}
