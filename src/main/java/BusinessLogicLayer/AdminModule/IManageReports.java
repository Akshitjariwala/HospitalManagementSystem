package BusinessLogicLayer.AdminModule;

public interface IManageReports {
  /* New Reports are added
   * The report details are taken as input
   * The details are stored into database
   */
  void addReports();

  /* The details of the reports can be updated
   * An input for the id is taken for which the details are needed to be updated
   * The details are fetched from database and are displayed
   * The user will have privilege to edit the details and the details are updated in database
   */
  void updateReports();
}
