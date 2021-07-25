package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Appointment;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.Appointments.IAppointmentDAO;
import PresentationLayer.AdminUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageAppointments extends AdminAbstractAction implements IManageAppointments {

  private IAppointmentDAO iAppointmentDAO;
  private static final String ACTION_TITLE = "Manage Appointments";

  public ManageAppointments() {
    iAppointmentDAO = iAdminActionDatabase.manageAppointments();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  public void manageAppointmentHome() {
    System.out.println(" Fetching Details... ");
    List<Appointment> appointments = iAppointmentDAO.getAppointmentList();

    if (appointments.size() != 0) {
      displayAppointments(appointments);
    } else {
      System.out.println("==================================================");
      System.out.println("\t\tNo Appointment Found\t\t");
      System.out.println("==================================================");
    }
    AdminUI adminLogin = new AdminUI();
    try {
      adminLogin.adminPage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void displayAppointments(List<Appointment> appointments) {
    int flag = 0;
    Scanner appIdInput = new Scanner(System.in);
    do {

      System.out.println("============================================================================================================");
      System.out.println("\t\t\t\t\t\t\t\t\t\tAll Appointments\t\t\t\t\t\t\t\t\t\t");
      System.out.println("============================================================================================================");
      System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-15s%n", "App. Id", "Patient Id", "Doctor Id", "App. Date", "Preferred Slot", "App. Type", "Status");
      ArrayList<Integer> appIds = new ArrayList<>();
      for (Appointment appointment : appointments) {
        appIds.add(appointment.getAppointmentId());
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-20s %-15s%n", appointment.getAppointmentId(), appointment.getPatientId(), appointment.getDoctorId(), appointment.getDate(), appointment.getPreferredSlot(), appointment.getTypeOfAppointment(), appointment.getAppointmentStatus());
      }

      System.out.println("\nUpdate Status of Appointment");
      System.out.println("Enter Appointment Id: ");
      String appIdText = appIdInput.next();
      int appId;
      if (appIdText.matches("[0-9]+")) {
        appId = Integer.parseInt(appIdText);
        if (appIds.contains(appId)) {
          int statusFlag = 0;

          do {
            System.out.println("Enter New Status (Confirmed / Reject): ");
            String appStatus = appIdInput.next();
            if (appStatus.equalsIgnoreCase("confirmed") || appStatus.equalsIgnoreCase("reject")) {
              System.out.println("Status Updating...");
              iAppointmentDAO.updateAppointmentStatus(appId, appStatus.toUpperCase());
              System.out.println("Status Updated Successfully");
              statusFlag = 1;
              System.out.println("\nUpdate Another Appointment Status ? (y / any other char)");
              String flagText = appIdInput.next();
              if (!flagText.equalsIgnoreCase("y")) {
                flag = 1;
              } else {
                appointments = iAppointmentDAO.getAppointmentList();
              }
            } else {
              System.out.printf("%n");
              System.out.println("Invalid Input Received! Please Enter valid Status.");
              System.out.printf("%n");
            }
          } while (statusFlag == 0);

        } else {
          System.out.printf("%n");
          System.out.println("Invalid Input Received! Please Select Appointment Id from above list only.");
          System.out.printf("%n");
        }
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Only Numbers are allowed");
        System.out.printf("%n");
      }
    } while (flag == 0);
  }
}