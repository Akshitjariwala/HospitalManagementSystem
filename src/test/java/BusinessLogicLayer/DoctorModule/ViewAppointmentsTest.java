package BusinessLogicLayer.DoctorModule;


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;




class ViewAppointmentsTest {
	private ViewAppointments viewappointment;

	@BeforeEach
	void setup() {
		viewappointment = Mockito.mock(ViewAppointments.class);
	}

	@Test
	void viewappointments_confirmed() {
		ViewAppointments v1=new ViewAppointments("janki123","CONFIRM");
	    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(true);

		assertEquals(false,v1.viewAllAppointments());
		
	}
	@Test
	void viewappointments_pending() {
		ViewAppointments v1=new ViewAppointments("janki123","Pending");
	    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(true);
		assertEquals(false, v1.viewAllAppointments());
	}
	@Test
	void viewappointments_NoAppointmentfound() {
		ViewAppointments v1=new ViewAppointments("janki1234","CONFIRM");
	    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(false);

		assertEquals(false,v1.viewAllAppointments());
	}


}


