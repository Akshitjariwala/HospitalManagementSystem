/*
 * CSCI 5308 Group Project
 * @author: Vishal Rakesh Jaiswal
 * @description: This program allows a doctor to view patients who either have appointnment with the doctor
 * or have been admitted against the doctor.
 * The database access is done using common DatabaseConnection class
 *
 * */
package BusinessLogicLayer.DoctorModule;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Patient;
import DatabaseLayer.ActionDatabase.Doctor.DoctorAbstractAction;
import DatabaseLayer.ActionDatabase.Doctor.ViewPatients.IViewPatientsDao;

public class ViewPatients extends DoctorAbstractAction implements IViewPatients {

  private int docId;
  private IViewPatientsDao iViewPatientsDao;
  private static final String ACTION_TITLE = "View Patients";

  public ViewPatients(int docId) {
    this.docId = docId;
    iViewPatientsDao=iDoctorActionDatabase.viewPatientsDao();
  }
  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }
  @Override
  public boolean viewAllPatients() {
    List<Patient> patients = iViewPatientsDao.getPatients(this.docId);
    if (patients.size() > 0) {
      System.out.println("================================================================");
      System.out.println("\t\t\t\tPatients under your supervision\t\t\t\t");
      System.out.println("================================================================");
      System.out.printf("%n");
      System.out.printf("%-10s %-10s %-10s %-10s", "Patient Id", "|", "FirstName", "|");
      System.out.printf("%-10s %-10s %-10s %-10s", "MiddleName", "|", "LastName", "|");
      System.out.printf("%-10s %-10s %-10s %-10s", "Address", "|", "EmailID", "|");
      System.out.printf("%-10s %-10s %-10s %-10s", "City", "|", "State", "|");
      System.out.printf("%-10s %-10s %-10s %10s %-10s%n", "Phone Number", "|", "EmergencyContactName", "|", "EmergencyContact2");
      for (Patient patient : patients) {
        System.out.printf("%-10s %-10s %-10s %-10s", patient.getUserID(), " | ", patient.getFirstName(), "|");
        System.out.printf("%-10s %-10s %-10s %-10s", patient.getMiddleName(), " | ", patient.getLastName(), "|");
        System.out.printf("%-10s %-10s %-10s %-10s", patient.getAddress(), " | ", patient.getEmaiID(), "|");
        System.out.printf("%-10s %-10s %-10s %-10s", patient.getCityName(), " | ", patient.getStateName(), "|");
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
