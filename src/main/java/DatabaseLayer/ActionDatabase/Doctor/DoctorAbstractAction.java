package DatabaseLayer.ActionDatabase.Doctor;


public abstract class DoctorAbstractAction {

  protected IDoctorActionDatabase iDoctorActionDatabase;

  public DoctorAbstractAction() {
    iDoctorActionDatabase = new DoctorActionDatabase();
  }

  public abstract String getActionTitle();
}
