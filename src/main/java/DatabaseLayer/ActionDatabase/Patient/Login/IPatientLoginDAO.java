package DatabaseLayer.ActionDatabase.Patient.Login;

public interface IPatientLoginDAO {

  String getLoginCredentials(String userID);

  String getPatientName(String userID);
}
