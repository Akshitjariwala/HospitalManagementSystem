package DatabaseLayer.ActionDatabase.Patient.ViewReports;

import java.sql.ResultSet;

public interface IViewPatientReportsDAO {

  ResultSet fetchLabReports(String patientID);
}
