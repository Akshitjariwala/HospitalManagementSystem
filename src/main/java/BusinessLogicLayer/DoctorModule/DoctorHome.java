package BusinessLogicLayer.DoctorModule;

import java.util.Scanner;

public class DoctorHome {
  int docId;

  public DoctorHome(int docId) {
    this.docId = docId;
  }

  public void doctorHomePage() {
    Scanner sc = new Scanner(System.in);
    System.out.println("=================================================");
    System.out.println("Welcome Doctor" + "\t" + this.docId);
    System.out.println("=================================================\n");
    do {
      System.out.println("1. View Appointments");
      System.out.println("2. View Patients");
      System.out.println("3. View Reports");
      System.out.println("4. Exit");
      System.out.println("Select a choice between 1-4 to perform appropriate action.\n");
      System.out.print("Enter Selection : ");
      int choice = sc.nextInt();
      if (choice > 0 && choice <= 4) {
        switch (choice) {
          case 1:
            System.out.print("Enter Appointment Status : ");
            String appointmentstatus = sc.next();
            ViewAppointments v1 = new ViewAppointments(this.docId, appointmentstatus);
            v1.viewAllAppointments();
            break;
          case 2:
            ViewPatients viewpatients = new ViewPatients(this.docId);
            viewpatients.viewAllPatients();
            break;
          case 3:
            ViewReports viewreports = new ViewReports(this.docId);
            System.out.println("1. View All the Reports\n2. View Patient-wise Reports");
            int ch = sc.nextInt();
            boolean flag3 = false;
            if (ch == 1)
              flag3 = viewreports.viewAllReports();
            else if (ch == 2) {
              System.out.print("Enter Patient Id : ");
              String patientId = sc.next();
              flag3 = viewreports.viewPatientReports(patientId);
            }
            if (ch != 1 || ch != 2)
              break;
            if (!flag3)
              System.out.println("Try a different option");
            break;
          case 4:
            System.exit(1);

        }
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
        System.out.printf("%n");
      }
    } while (true);
  }
}
