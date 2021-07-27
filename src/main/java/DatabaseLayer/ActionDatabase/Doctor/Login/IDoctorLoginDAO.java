package DatabaseLayer.ActionDatabase.Doctor.Login;

import BusinessLogicLayer.BeanClasses.Doctor;

public interface IDoctorLoginDAO {

  int checkDoctorLogin(String id, String password);

  Doctor getDoctor(String id, String password);

}
