package DatabaseLayer.ActionDatabase.Admin.Reports;

import BusinessLogicLayer.BeanClasses.Reports;

public interface IUpdateReportsDAO {

  void updateReport(String str, int id);

  Reports getReportsDetails(int id);


}
