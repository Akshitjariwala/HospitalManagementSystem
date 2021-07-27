package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Patient.Registration.PatientRegistrationDAO;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientRegistrationDAOTest {

    @Test
    public void savePatientDetailsTest()  {
        PatientRegistrationDAO patientRegistrationDAO=new PatientRegistrationDAO();
        Patient patient=new Patient();
        patient.setFirstName("mansi");
        patient.setLastName("patel");
        patient.setEmaiID("qawsed@wsedxc.sa");
        patient.setCityName("Halifax");
        patient.setStateName("NS");
        patient.setUserID("mansi123");
        patient.setPassword("Qawsed@sxdc23");
        assertEquals(1, patientRegistrationDAO.savePatientDetails(patient));
    }
}
