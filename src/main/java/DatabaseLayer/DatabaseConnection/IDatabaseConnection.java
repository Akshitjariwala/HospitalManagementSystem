package DatabaseLayer.DatabaseConnection;

import java.sql.Connection;

public interface IDatabaseConnection {

    Connection openDBConnection();

    void closeDBConnection();
}
