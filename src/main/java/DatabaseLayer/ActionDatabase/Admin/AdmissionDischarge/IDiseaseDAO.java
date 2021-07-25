package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import java.sql.SQLException;
import java.util.Map;

public interface IDiseaseDAO {
    Map<Integer, String> getDiseaseList() throws SQLException;
    
    String getDiseaseName(int diseaseID) throws SQLException;
}
