package DatabaseLayer.Dao;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
public class BookAppointmentsDAOTest {

    @Test
    public void getPatientNameTest()  {

        BookAppointmentsDAO bookAppointmentsDAO=new BookAppointmentsDAO();
        assertEquals("Kishan Patel",bookAppointmentsDAO.getPatientName("User2409"));
    }

}
