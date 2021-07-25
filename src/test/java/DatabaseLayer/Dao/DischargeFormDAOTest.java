package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.DischargeFormDAO;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.IDischargeFormDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class DischargeFormDAOTest {
    
    private final long timeToMil = System.currentTimeMillis();
    private final Date date = new Date(timeToMil);
    public IDischargeFormDAO dischargeForm;
    
    @BeforeEach
    void setup() {
        dischargeForm = Mockito.mock(DischargeFormDAO.class);
    }

    @Test
    void dischargePatient() {
        Admission admission = new Admission("doe999", 2, 3, 1, 3, 4);
        admission.setDischargeDate(date);
        admission.setAdmissionID(50);
        admission.setDischargeComment("Patient is allowed to leave.");
        Mockito.when(dischargeForm.dischargePatient(admission)).thenReturn(Boolean.valueOf("true"));
        assertTrue(dischargeForm.dischargePatient(admission), "Test Failed!. Incorrect or No value received.");
    
    }
}