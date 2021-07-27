/*
 * CSCI 5308 Group Project
 * @author: Vishal Rakesh Jaiswal
 * @description: This program allows a doctor to view appointments booked with the doctor
 * The database access is done using common DatabaseConnection class
 * */
package BusinessLogicLayer.DoctorModule;
import java.util.List;

import DatabaseLayer.ActionDatabase.Doctor.DoctorAbstractAction;
import DatabaseLayer.ActionDatabase.Doctor.ViewAppointments.IViewAppointmentsDao;
import BusinessLogicLayer.BeanClasses.Appointment;

public class ViewAppointments extends DoctorAbstractAction implements IViewAppointments{
  private int docId;
  private String status;
  private IViewAppointmentsDao iViewAppointmentsDao;
  private static final String ACTION_TITLE = "View Appointments";


  public ViewAppointments(int docId, String status) {
    this.docId = docId;
    this.status = status;
    iViewAppointmentsDao=iDoctorActionDatabase.viewAppointmentsDao();
  }
  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }
  @Override
  public boolean viewAllAppointments() {
    List<Appointment> appointments = iViewAppointmentsDao.getAppointmentList(this.docId, status);
    System.out.println("=================================================");
    System.out.println("\t\t\t\tYour appointments\t\t\t\t");
    System.out.println("=================================================");
    if (appointments.size() > 0) {
      System.out.printf("%-10s %-10s %-10s %-10s", "App. Id", "|", "Patient Id", "|");
      System.out.printf("%-10s %-10s %-10s%n", "App. Date", "|", "Preferred Slot");
      for (Appointment a : appointments) {
        System.out.printf("%-10s %-10s %-10s %-10s", a.getAppointmentId(), "|", a.getPatientId(), "|");
        System.out.printf("%-10s %-10s %-10s%n", a.getDate(), "|", a.getPreferredSlot());
      }
      System.out.printf("%n");
      return true;
    } else {
      System.out.println("No appointments with " + this.status.toUpperCase().trim() + " Status for you.\n");
      return false;
    }
  }
}
