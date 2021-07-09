package BusinessLogicLayer.DoctorModule;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import BusinessLogicLayer.AdminModule.Appointment;



class ViewAppointmentsTest {
	private ViewAppointmentsDao viewappointmentDAO;

	@BeforeEach
	void setup() {
		viewappointmentDAO = Mockito.mock(ViewAppointmentsDao.class);
	}

	@Test
	void viewappointments_confirmed() {
		ViewAppointments v1=new ViewAppointments("janki123","CONFIRM");
		assertEquals(true,v1.viewAllAppointments());
		
	}
	@Test
	void viewappointments_pending() {
		ViewAppointments v1=new ViewAppointments("janki123","Pending");
		assertEquals(true, v1.viewAllAppointments());
	}
	@Test
	void viewappointments_NoAppointmentfound() {
		ViewAppointments v1=new ViewAppointments("janki1234","CONFIRM");
		assertEquals(false,v1.viewAllAppointments());
	}


}


