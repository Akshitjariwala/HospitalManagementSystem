package DatabaseLayer.Dao.Interfaces;

import java.sql.ResultSet;

public interface IViewPatientReportsDAO {

    ResultSet fetchLabReports(String patientID);
}
