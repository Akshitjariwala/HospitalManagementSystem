package Database;

import java.sql.ResultSet;

public class InitiateDatabase {
    public ResultSet performRead(IDatabaseRead iDatabaseRead){
        return iDatabaseRead.matchedRecords();
    }
}
