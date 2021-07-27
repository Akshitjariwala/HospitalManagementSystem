package DatabaseLayer.ActionDatabase.Admin;

public abstract class AdminAbstractAction {

  protected IAdminActionDatabase iAdminActionDatabase;

  public AdminAbstractAction() {

    iAdminActionDatabase = new AdminActionDatabase();
  }

  public abstract String getActionTitle();
}
