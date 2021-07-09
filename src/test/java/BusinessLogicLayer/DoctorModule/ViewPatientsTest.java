package BusinessLogicLayer.DoctorModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewPatientsTest {
	
	private ViewPatients viewPatients;
	@BeforeEach
	void setup() {
		viewPatients = Mockito.mock(ViewPatients.class);
	}


	@Test
	void test_viewPatientWhenExists() {
		ViewPatients vp1=new ViewPatients("janki123");
		viewPatients.docId=vp1.docId;
		assertEquals(true,Mockito.when(viewPatients.viewAllPatients()).thenReturn(true));
	}
	

	@Test
	void test_viewPatientNotExists() {
		ViewPatients vp1=new ViewPatients("janki1234");
		viewPatients.docId=vp1.docId;
		assertEquals(false,Mockito.when(viewPatients.viewAllPatients()).thenReturn(false));
	}

}
