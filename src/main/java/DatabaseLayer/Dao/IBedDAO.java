package DatabaseLayer.Dao;

import java.sql.SQLException;
import java.util.Map;

public interface IBedDAO {
    Map<Integer, String> getAvailableBeds() throws SQLException;
    
    String getBedCode(int bedID) throws SQLException;
}
