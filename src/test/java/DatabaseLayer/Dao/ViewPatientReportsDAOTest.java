package DatabaseLayer.Dao;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class ViewPatientReportsDAOTest  {

    @Test
    public void fetchLabReports() throws SQLException {

        ViewPatientReportsDAO viewPatientReportsDAO=new ViewPatientReportsDAO();
        ResultSet resultSet=viewPatientReportsDAO.fetchLabReports("User2409");
        assertEquals(0,resultSet.getRow());
    }
}
