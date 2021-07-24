package DatabaseLayer.Dao;

import java.sql.SQLException;
import java.util.Map;

public interface IWardDAO {
    Map<Integer, String> getWardsList() throws SQLException;
    
    String getWardCode(int wardID) throws SQLException;
}
