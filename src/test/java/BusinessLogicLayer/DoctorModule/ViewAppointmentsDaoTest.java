package BusinessLogicLayer.DoctorModule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import BusinessLogicLayer.AdminModule.Appointment;

class ViewAppointmentsDaoTest {

	private ViewAppointmentsDao viewappointmentDAO;

	  @BeforeEach
	  void setup() {
	    viewappointmentDAO = Mockito.mock(ViewAppointmentsDao.class);
	  }

	  @Test
	  void getAppointmentListTest() {
	    Appointment appointment1 = new Appointment(1, "joe999", "janki123", "09/07/2021", "Morning", "In Person", "Pending");
	    Appointment appointment2 = new Appointment(2, "joe999", "janki123", "10/07/2021", "Morning", "In Person", "Pending");
	    String query="Select * from appointments";
	    ArrayList<Appointment> appointments = new ArrayList<>(Arrays.asList(appointment1, appointment2));
	    Mockito.when(viewappointmentDAO.getAppointmentList(query)).thenReturn(appointments);
	    assertEquals(2, appointments.size());
	  }


}
