package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Doctor;

public interface IUpdateDoctorDAO {

  Doctor getDoctor(String id);

  void updateDoctor(String s, int id);

}
