package DatabaseLayer.ActionDatabase.Admin;

import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.*;
import DatabaseLayer.ActionDatabase.Admin.Appointments.AppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Appointments.IAppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.BedDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import DatabaseLayer.ActionDatabase.Admin.ManageDoctor.IManageDoctorDAO;
import DatabaseLayer.ActionDatabase.Admin.ManageDoctor.ManageDoctorDAO;
import DatabaseLayer.ActionDatabase.Admin.Reports.IManageReportsDAO;
import DatabaseLayer.ActionDatabase.Admin.Reports.ManageReportsDAO;
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
  public IAppointmentDAO manageAppointments() {
    return new AppointmentDAO();
  }

  @Override
  public IAdmissionFormDAO saveAdmissionForm() {
    return new SaveAdmissionFormDAO();
  }

  @Override
  public IAdmissionDetailsDAO admissionDetailsDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IAdmissionTypeDAO admissionTypeDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IBedAdmissionDAO bedAdmissionDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IDiseaseDAO diseaseDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IDoctorDAO doctorDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IPatientDAO patientDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IDischargeFormDAO dischargeDAO() {
    return new DischargeFormDAO();
  }

  @Override
  public IWardAdmissionDAO wardAdmissionDAO() {
    return new AdmissionDAO();
  }

  @Override
  public IManageDoctorDAO manageDocDAO() {
    return new ManageDoctorDAO();
  }

  @Override
  public IManageReportsDAO reportsDAO() {
    return new ManageReportsDAO();
  }
}
