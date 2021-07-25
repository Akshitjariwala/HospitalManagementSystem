package DatabaseLayer.Dao.Interfaces;

import BusinessLogicLayer.BeanClasses.Patient;

public interface IPatientRegistrationDAO {

    int savePatientDetails(Patient patient);
}
