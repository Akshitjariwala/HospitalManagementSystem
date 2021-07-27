package DatabaseLayer.ActionDatabase.Admin.Reports;

import BusinessLogicLayer.BeanClasses.Reports;

public interface IManageReportsDAO {

  int addReport(Reports report);

  int checkDoctorId(String id);

  String checkPatientId(String id);

  void updateReport(String str, int id);

  Reports getReportsDetails(int id);

}
