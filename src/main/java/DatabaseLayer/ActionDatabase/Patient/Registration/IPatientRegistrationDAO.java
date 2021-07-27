package DatabaseLayer.ActionDatabase.Patient.Registration;

import BusinessLogicLayer.BeanClasses.Patient;

public interface IPatientRegistrationDAO {

  int savePatientDetails(Patient patient);
}
