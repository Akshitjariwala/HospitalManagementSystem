package DatabaseLayer.ActionDatabase.Admin.ManageDoctor;

import BusinessLogicLayer.BeanClasses.Doctor;

public interface IManageDoctorDAO {
  int addDoctor(Doctor doct);

  Doctor getDoctor(String id);

  void updateDoctor(String s, int id);
}
