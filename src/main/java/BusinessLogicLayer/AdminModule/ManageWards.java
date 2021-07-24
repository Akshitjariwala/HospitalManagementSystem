package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.BedCounts;
import BusinessLogicLayer.BeanClasses.PatientBed;
import BusinessLogicLayer.BeanClasses.Ward;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.Beds.IBedDAO;
import DatabaseLayer.ActionDatabase.Admin.Wards.IWardDAO;
import PresentationLayer.WardUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageWards extends AdminAbstractAction implements IWardActions, IBedActions {

  private IWardDAO iWardDAO;
  private IBedDAO iBedDAO;
  private static String updateStr = "";
  private static final String ACTION_TITLE = "Manage Wards";

  public ManageWards() {
    iWardDAO = iAdminActionDatabase.manageWard();
    iBedDAO = iAdminActionDatabase.manageBed();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  @Override
  public void addWards() {
    Ward ward = new Ward();
    Scanner inputData = new Scanner(System.in);
    System.out.println("============================================================================");
    System.out.println("                      Add Wards");
    System.out.println("============================================================================");

    do {
      System.out.println("Ward Name :");
      String wardName = inputData.nextLine();
      if (wardName.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setWardName(wardName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getWardName() == null);

    do {
      System.out.println("Ward Location :");
      String location = inputData.nextLine();
      if (location.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setLocation(location);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getLocation() == null);

    do {
      System.out.println("Bed Type :");
      String bedType = inputData.nextLine();
      if (bedType.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setBedType(bedType);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getBedType() == null);

    do {
      System.out.println("Total Beds :");
      int totalBeds = inputData.nextInt();
      if (totalBeds > 0) {
        ward.setTotalBeds(totalBeds);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getTotalBeds() == 0);

    do {
      System.out.println("Ward Type(Covid/Non-Covid/General/Children/Emergency) :");
      String wardType = inputData.next();
      if (wardType.matches("^[a-zA-Z0-9_ ]*$")) {
        ward.setWardType(wardType);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (ward.getWardType() == null);

    int status = iWardDAO.addWard(ward);
    if (status == 1) {
      System.out.println("Ward details added successfully");
    } else {
      System.out.println("ERROR while adding ward");
    }
    WardUI wardHome = new WardUI();
    wardHome.wardManageHomePage();
  }

  @Override
  public void updateWards() {
    System.out.println("Enter the id of the ward that has to be updated");
    Scanner scanner = new Scanner(System.in);
    int id = scanner.nextInt();
    Ward ward = iWardDAO.getWard(id);
    int wardId = ward.getWardId();

    System.out.println("===========The details of the ward" + " " + wardId + "are==================");
    System.out.println("1. Ward Type :" + ward.getWardType());
    System.out.println("2. Ward Name :" + ward.getWardName());
    System.out.println("3. Ward Location :" + ward.getLocation());
    System.out.println("4. Total Beds :" + ward.getTotalBeds());
    System.out.println("5. Bed Type :" + ward.getBedType());
    System.out.println("6. Go to Ward Management");
    System.out.printf("%n");
    System.out.print("Enter Selection : ");
    int input = scanner.nextInt();
    switch (input) {
      case 1:
        System.out.println("Enter Ward Type :");
        String wardType = scanner.next();
        updateStr = "ward_type = " + "'" + wardType + "'";
        break;
      case 2:
        System.out.println("Enter Ward Name :");
        String wardName = scanner.next();
        updateStr = "name = " + "'" + wardName + "'";
        break;
      case 3:
        System.out.println("Enter Ward Location :");
        String wardLocation = scanner.next();
        updateStr = "location = " + "'" + wardLocation + "'";
        break;
      case 4:
        System.out.println("Enter Total Beds :");
        String totalBeds = scanner.next();
        updateStr = "total_beds = " + totalBeds;
        break;
      case 5:
        System.out.println("Enter Bed Type :");
        String bedType = scanner.next();
        updateStr = "bed_type = " + "'" + bedType + "'";
        break;
      case 6:
        WardUI wardHome = new WardUI();
        wardHome.wardManageHomePage();
        break;
      default:
        System.out.println("Invalid Input, Please choose valid input ");
    }
    if (!updateStr.isEmpty()) {
      iWardDAO.updateWard(updateStr, wardId);
      System.out.println("Ward Details updated Successfully.");
      WardUI wardHome = new WardUI();
      wardHome.wardManageHomePage();
    }
  }

  @Override
  public void checkBedAvailability() {
    System.out.println("==================================================");
    System.out.println("\t\t\t\tCurrent Bed Availability\t\t\t\t");
    System.out.println("==================================================");
    List<BedCounts> bedcount = iBedDAO.showCurrentAvailableBeds();
    if (bedcount.size() != 0) {
      System.out.printf("%-15s %-10s %-10s %10s %10s%n", "Ward Id", "|", "Bed type", "|", "Number of Available beds");
      for (BedCounts bd : bedcount) {
        Ward w = bd.getWard();
        System.out.printf("%-15s %-10s %-10s %10s %10s%n", w.getWardId(), "|", bd.getBedType(), "|", bd.getNumberOfBeds());
      }
    } else {
      System.out.println("\t\t Currently no beds are available, Please try again later\t\t");
    }
    WardUI wardHome = new WardUI();
    wardHome.wardManageHomePage();
  }

  @Override
  public void checkPatientWiseBedDetails() {
    System.out.println("==================================================");
    System.out.println("\t\t\t\tPatient-wise Bed Details\t\t\t\t");
    System.out.println("==================================================");

    int wardId = -1;
    do {
      wardId = getSelectedWard();
      System.out.println(" Fetching Details... ");
    } while (wardId == -1);

    List<PatientBed> patientBeds = iBedDAO.getPatientBed(wardId);
    if (patientBeds.size() != 0) {
      System.out.println("================================================================");
      System.out.println("\t\t\t\t\tPatients with Occupied Beds\t\t\t\t\t");
      System.out.println("================================================================");
      System.out.printf("%-15s %-10s %-10s %10s %10s%n", "Patient Name", "|", "Patient Id", "|", "Bed Detail");
      for (PatientBed patientBed : patientBeds) {
        System.out.printf("%-15s %-10s %-10s %10s %10s%n", patientBed.getPatientName(), "|", patientBed.getPatientId(), "|", patientBed.getBed().getBedCode());
      }
    } else {
      System.out.println("==================================================");
      System.out.println("\t\tPatients not admitted in this ward\t\t");
      System.out.println("==================================================");
    }
    WardUI wardHome = new WardUI();
    wardHome.wardManageHomePage();
  }

  @Override
  public int getSelectedWard() {
    int flag = 0;
    int wardId = -1;
    do {
      Scanner wardIdInput = new Scanner(System.in);
      ArrayList<Integer> wardIds = new ArrayList<>();

      System.out.println(" Select a ward first to get Patient-wise Bed Details ");
      System.out.println(" Loading... ");
      List<Ward> result = iWardDAO.getWardsList();
      System.out.printf("%n");
      System.out.printf("%-10s %-10s %-10s%n", "Ward Id", " | ", "Ward Name");
      System.out.println("=====================================");
      for (Ward ward : result) {
        wardIds.add(ward.getWardId());
        System.out.printf("%-10s %-10s %-10s%n", ward.getWardId(), " | ", ward.getWardName());
      }
      System.out.printf("%n");
      System.out.print("Enter Ward Id\t: ");
      String wardIdParse = wardIdInput.next();
      int wardID = -1;
      if (wardIdParse.matches("[0-9]+")) {
        wardID = Integer.parseInt(wardIdParse);
        if (wardIds.contains(wardID)) {
          wardId = wardID;
          flag = 1;
        } else {
          System.out.printf("%n");
          System.out.println("Invalid Input Received! Please Select Ward Id from above list only.");
          System.out.printf("%n");
        }
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Only Numbers are allowed");
        System.out.printf("%n");
      }
    } while (flag == 0);
    return wardId;
  }
}
