package BusinessLogicLayer;

import BusinessLogicLayer.PatientModule.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    public void getFirstNameTest(){
        Patient patient=new Patient();
        assertEquals("kishan",patient.getFirstName(),"getFirstNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getLastNameTest(){
        Patient patient=new Patient();
        assertEquals("patel",patient.getLastName(),"getLastNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getMiddleNameTest(){
        Patient patient =new Patient();
        assertEquals("patel",patient.getMiddleName(),"getMiddleNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmaiIDTest(){
        Patient patient =new Patient();
        assertEquals("mahesh@gmail.com",patient.getEmaiID(),"getEmaiIDTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getPhoneNumberTest(){
        Patient patient =new Patient();
        assertEquals("8868872212",patient.getPhoneNumber(),"getPhoneNumberTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getAddressTest(){
        Patient patient =new Patient();
        assertEquals("234-Shreepad Anantta",patient.getAddress(),"getAddressTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getCityNameTest(){
        Patient patient =new Patient();
        assertEquals("Surat",patient.getCityName(),"getCityNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getStateNameTest(){
        Patient patient =new Patient();
        assertEquals("Gujarat",patient.getStateName(),"getStateNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmergencyContactNameTest(){
        Patient patient =new Patient();
        assertEquals("Rahul",patient.getEmergencyContactName(),"getEmergencyContactNameTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getEmergencyContactNumberTest(){
        Patient patient =new Patient();
        assertEquals("5566778990",patient.getEmergencyContactName(),"getEmergencyContactNumberTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getUserIDTest(){
        Patient patient =new Patient();
        assertEquals("kishan@234",patient.getEmergencyContactName(),"getUserIDTest Failed : Incorrect value or False value received ! ! !");
    }

    @Test
    public void getPasswordTest(){
        Patient patient =new Patient();
        assertEquals("Qawsedzx@234",patient.getPassword(),"getPasswordTest Failed : Incorrect value or False value received ! ! !");
    }


}
