package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Reports;

public interface IAddReportsDAO {

  int addReport(Reports report);

  int checkDoctorId(int id);

  String checkPatientId(String id);


}