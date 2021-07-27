package DatabaseLayer.ActionDatabase.Admin;

import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.*;
import DatabaseLayer.ActionDatabase.Admin.Appointments.IAppointmentDAO;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import DatabaseLayer.ActionDatabase.Admin.ManageDoctor.IManageDoctorDAO;
import DatabaseLayer.ActionDatabase.Admin.Reports.IManageReportsDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.IWardDAO;

public interface IAdminActionDatabase {

  IWardDAO manageWard();

  IBedDAO manageBed();

  IAppointmentDAO manageAppointments();

  IAdmissionFormDAO saveAdmissionForm();

  IAdmissionDetailsDAO admissionDetailsDAO();

  IAdmissionTypeDAO admissionTypeDAO();

  IBedAdmissionDAO bedAdmissionDAO();

  IDiseaseDAO diseaseDAO();

  IDoctorDAO doctorDAO();

  IPatientDAO patientDAO();

  IDischargeFormDAO dischargeDAO();

  IWardAdmissionDAO wardAdmissionDAO();

  IManageReportsDAO reportsDAO();

  IManageDoctorDAO manageDocDAO();
}
