package DatabaseLayer.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Doctor.ViewPatients.ViewPatientsDao;

class ViewPatientsDaoTest {

  private ViewPatientsDao viewpatientsDAO;

  @BeforeEach
  void setup() {
    viewpatientsDAO = Mockito.mock(ViewPatientsDao.class);
  }

  @Test
  void getPatientstest() {
    Patient patient1 = new Patient("vishal", "jaiswal", "r", "vis@gmail.com", "7021267420", "MumbaISouth", "Mumbai", "Maha", "tush", "7894561230", "vis123", "yk12345");
    Patient patient2 = new Patient("vis", "jais", "io", "vis1@gmail.com", "7021267420", "MumbaISouth", "Mumbai", "Maha", "tush", "7894561230", "vis123", "yk12345");
    int docId = 1;
    ArrayList<Patient> patients = new ArrayList<>(Arrays.asList(patient1, patient2));
    Mockito.when(viewpatientsDAO.getPatients(docId)).thenReturn(patients);
    assertEquals(2, patients.size());
  }

  @Test
  void getPatientstest2() {
    int docId = 1;
    ArrayList<Patient> patients = new ArrayList<>(Collections.emptyList());
    Mockito.when(viewpatientsDAO.getPatients(docId)).thenReturn(patients);
    assertEquals(0, patients.size());
  }


}
