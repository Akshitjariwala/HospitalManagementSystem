package DatabaseLayer.ActionDatabase.Admin;

public class AdminActionDatabase implements IAdminActionDatabase {

  @Override
  public IManageWardDatabase manageWard() {
    return new ManageWardDatabase();
  }

  @Override
  public IAdmissionDischargeDatabase admissionDischarge() {
    return null;
  }

  @Override
  public IManageAppointmentDatabase manageAppointments() {
    return new ManageAppointmentDatabase();
  }
}
