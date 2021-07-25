package BusinessLogicLayer.DoctorModule;
/*
 * CSCI 5308 Group Project
 * @author: Vishal Rakesh Jaiswal
 * @description: This program allows a doctor to view appointments booked with the doctor
 * The database access is done using common DatabaseConnection class
 *
 * */
import java.util.List;

import DatabaseLayer.Dao.ViewAppointmentsDao;
import BusinessLogicLayer.BeanClasses.Appointment;

public class ViewAppointments implements IViewAppointments{
  private int docId;
  private String status;
  private ViewAppointmentsDao vdao;

  public ViewAppointments(int docId, String status) {
    this.docId = docId;
    this.status = status;
    vdao = new ViewAppointmentsDao();
  }
  @Override
  public boolean viewAllAppointments() {
    List<Appointment> appointments = vdao.getAppointmentList(this.docId, status);
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
