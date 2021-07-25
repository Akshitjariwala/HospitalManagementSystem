package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import BusinessLogicLayer.BeanClasses.Admission;

public interface IDischargeFormDAO {
  boolean dischargePatient(Admission admission);
}
