package BusinessLogicLayer.DoctorModule;

import java.util.ArrayList;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.Dao.ViewPatientsDao;

public class ViewPatients {

  int docId;
  ViewPatientsDao pdao;

  public ViewPatients(int docId) {
    // TODO Auto-generated constructor stub
    this.docId = docId;
    pdao = new ViewPatientsDao();
  }

  public boolean viewAllPatients() {
    // TODO Auto-generated method stub
    ArrayList<Patient> patients = new ArrayList<Patient>();
    patients = pdao.getPatients(this.docId);
    if (patients == null)
      return false;
    if (patients != null && patients.size() > 0) {
      System.out.println("================================================================");
      System.out.println("\t\t\t\tPatients under your supervision\t\t\t\t");
      System.out.println("================================================================");
      System.out.printf("%n");
      System.out.printf("%-10s %-10s %-20s", "Patient Id", " | ", "FirstName");
      System.out.printf("%-20s %-10s %-20s", "MiddleName", " | ", "LastName");
      System.out.printf("%-50s %-10s %-30s", "Address", " | ", "EmailID");
      System.out.printf("%-10s %-10s %-10s", "City", " | ", "State");
      System.out.printf("%-10s %-10s %-10s %10s %-10s%n", "Phone Number", " | ", "EmergencyContactName", "|", "EmergencyContact2");
      for (Patient patient : patients) {
        System.out.printf("%-10s %-10s %-20s", patient.getUserID(), " | ", patient.getFirstName());
        System.out.printf("%-20s %-10s %-20s", patient.getMiddleName(), " | ", patient.getLastName());
        System.out.printf("%-50s %-10s %-30s", patient.getAddress(), " | ", patient.getEmaiID());
        System.out.printf("%-10s %-10s %-10s", patient.getCityName(), " | ", patient.getStateName());
        System.out.printf("%-10s %-10s %-10s %10s %-10s%n", patient.getPhoneNumber(), " | ", patient.getEmergencyContactName(), "|", patient.getEmergencyContactNumber());
      }
      return true;
    } else {
      System.out.println("==================================================");
      System.out.println("\t\tCurrently no patients under your supervision\t\t");
      System.out.println("==================================================");
      return false;
    }
  }
}
