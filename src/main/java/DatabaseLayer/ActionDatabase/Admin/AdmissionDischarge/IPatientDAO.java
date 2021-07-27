package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import java.sql.SQLException;

public interface IPatientDAO {
    String getPatient(String patientID) throws SQLException;

    boolean ifPatientExists(String patientID) throws SQLException;
}
