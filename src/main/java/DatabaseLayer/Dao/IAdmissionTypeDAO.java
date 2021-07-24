package DatabaseLayer.Dao;

import java.sql.SQLException;
import java.util.Map;

public interface IAdmissionTypeDAO {
    String getAdmissionType(int admissionTypeID) throws SQLException;
    
    Map<Integer, String> getAdmissionTypesList() throws SQLException;
}
