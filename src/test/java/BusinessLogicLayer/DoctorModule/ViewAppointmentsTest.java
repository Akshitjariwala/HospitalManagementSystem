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
		viewappointment.docId=v1.docId;
		viewappointment.status=v1.status;
	    Mockito.when(viewappointment.viewAllAppointments()).thenReturn(true);

		assertEquals(true, Mockito.when(viewappointment.viewAllAppointments()).thenReturn(true));
		
	}
	@Test
	void viewappointments_pending() {
		ViewAppointments v1=new ViewAppointments("janki123","Pending");
		viewappointment.docId=v1.docId;
		viewappointment.status=v1.status;
		assertEquals(true,Mockito.when(viewappointment.viewAllAppointments()).thenReturn(true));

	}
	@Test
	void viewappointments_NoAppointmentfound() {
		ViewAppointments v1=new ViewAppointments("janki1234","CONFIRM");
		viewappointment.docId=v1.docId;
		viewappointment.status=v1.status;
		assertEquals(false,Mockito.when(viewappointment.viewAllAppointments()).thenReturn(false));

	}


}


