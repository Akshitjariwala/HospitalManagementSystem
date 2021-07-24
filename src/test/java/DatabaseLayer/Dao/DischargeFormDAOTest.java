package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Admission;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;

class DischargeFormDAOTest {
    
    public DischargeFormDAO dischargeForm;
    private final long timeToMil = System.currentTimeMillis();
    private final Date date = new Date(timeToMil);

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