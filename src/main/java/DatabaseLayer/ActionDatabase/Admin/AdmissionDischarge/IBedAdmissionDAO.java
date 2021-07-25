package DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge;

import java.sql.SQLException;
import java.util.Map;

public interface IBedAdmissionDAO {

  Map<Integer, String> getAvailableBeds() throws SQLException;

  String getBedCode(int bedID) throws SQLException;
}
