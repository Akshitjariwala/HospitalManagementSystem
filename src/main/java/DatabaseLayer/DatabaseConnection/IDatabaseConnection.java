package DatabaseLayer.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;

public interface IDatabaseConnection {

  Connection openDBConnection();

  void closeDBConnection();

  Statement createStatement(Connection connection);
}
