package DatabaseLayer.ActionDatabase.Doctor.ViewPatients;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Patient;

public interface IViewPatientsDao {

	List<Patient> getPatients(int docId);
}
