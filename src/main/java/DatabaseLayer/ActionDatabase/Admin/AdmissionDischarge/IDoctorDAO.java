package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import java.sql.SQLException;
import java.util.Map;

public interface IDoctorDAO {
    Map<Integer, String> getDoctorList() throws SQLException;
    
    int getDoctor(int doctorID) throws SQLException;
    
    String getDoctorName(int doctorID) throws SQLException;
}
