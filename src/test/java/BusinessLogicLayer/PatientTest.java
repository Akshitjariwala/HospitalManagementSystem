package BusinessLogicLayer;

import BusinessLogicLayer.PatientModule.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void getFirstNameTest(){
        Patient patient=new Patient();
        assertEquals(null,patient.getFirstName(),"getFirstNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getLastNameTest(){
        Patient patient=new Patient();
        assertEquals(null,patient.getLastName(),"getLastNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getMiddleNameTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getMiddleName(),"getMiddleNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmaiIDTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getEmaiID(),"getEmaiIDTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getPhoneNumberTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getPhoneNumber(),"getPhoneNumberTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getAddressTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getAddress(),"getAddressTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getCityNameTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getCityName(),"getCityNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getStateNameTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getStateName(),"getStateNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmergencyContactNameTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getEmergencyContactName(),"getEmergencyContactNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmergencyContactNumberTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getEmergencyContactName(),"getEmergencyContactNumberTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getUserIDTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getEmergencyContactName(),"getUserIDTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getPasswordTest(){
        Patient patient =new Patient();
        assertEquals(null,patient.getPassword(),"getPasswordTest Failed : Incorrect value or False value received ! ! !");
    }


}
