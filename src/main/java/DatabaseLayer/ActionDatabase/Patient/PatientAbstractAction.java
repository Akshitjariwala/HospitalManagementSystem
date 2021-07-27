package DatabaseLayer.ActionDatabase.Patient;


public abstract class PatientAbstractAction {

  protected IPatientActionDatabase iPatientActionDatabase;

  public PatientAbstractAction() {
    iPatientActionDatabase = new PatientActionDatabase();
  }

  public abstract String getActionTitle();
}
