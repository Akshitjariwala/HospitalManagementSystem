package DatabaseLayer.Dao.Interfaces;

public interface IPatientLoginDAO  {

    String getLoginCredentials(String userID);
    String getPatientName(String userID);
}
