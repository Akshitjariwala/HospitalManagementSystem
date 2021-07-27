package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import java.sql.SQLException;
import java.util.Map;

public interface IWardAdmissionDAO {
  Map<Integer, String> getWardsList() throws SQLException;

  String getWardCode(int wardID) throws SQLException;
}
