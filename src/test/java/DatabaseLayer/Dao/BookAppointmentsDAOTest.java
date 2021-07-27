package DatabaseLayer.Dao;

import DatabaseLayer.ActionDatabase.Patient.BookAppointments.BookAppointmentsDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BookAppointmentsDAOTest {

    @Test
    public void getPatientNameTest()  {

        BookAppointmentsDAO bookAppointmentsDAO=new BookAppointmentsDAO();
        assertEquals("Kishan Patel",bookAppointmentsDAO.getPatientName("User2409"));
    }

}
