package BusinessLogicLayer.WardModule;

import BusinessLogicLayer.AdminModule.AddWards;
import BusinessLogicLayer.AdminModule.UpdateWards;
import DatabaseLayer.ActionDatabase.Admin.ManageWardDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class WardHome extends ManageWardDatabase implements IWardActions {

	public WardHome() {
	}

	// wardManageHomePage() method returns Ward module home page.
	public void wardManageHomePage() {
		int flag = 0;
		do {
			System.out.println("=================================================");
			System.out.println("\t\t\t\tWard Management\t\t\t\t");
			System.out.println("=================================================");
			System.out.printf("%n");
			System.out.println("1. Add new Wards");
			System.out.println("2. Update existing Wards");
			System.out.println("3. Show bed Availability");
			System.out.println("4. Patient-wise bed details");
			System.out.println("5. Main Menu");
			System.out.println("6. Exit");
			System.out.printf("%n");
			System.out.print("Select number between 1-6 to perform appropriate action.");
			System.out.printf("%n");
			System.out.print("Enter Selection : ");

			Scanner userInput = new Scanner(System.in);
			int choice = userInput.nextInt();
			if (choice > 0 && choice <= 5) {
				switch (choice) {
				case 1:
					AddWards.addWards();// call add new wards method here
					flag = 1;
					break;
				case 2:
					try {
						UpdateWards.updateWards();// call check bed availability method here
					} catch (SQLException sqlException) {
						sqlException.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					flag = 1;
					break;
				case 3:
					//checkBedAvailability();// call patient-wise bed details method here
					flag = 1;
					break;
				case 4:
					checkPatientWiseBedDetails();// call patient-wise bed details method here
					flag = 1;
					break;
				case 5:
					// call main menu
					flag = 1;
				case 6:
					System.exit(1);// exit()
					flag = 1;
				}
			} else {
				System.out.printf("%n");
				System.out.println("Invalid Input Received! Please Enter Valid Selection.");
				System.out.printf("%n");
			}
		} while (flag == 0);
	}

	@Override
	public void checkBedAvailability() {
		System.out.println("==================================================");
		System.out.println("\t\t\t\tCurrent Bed Availability\t\t\t\t");
		System.out.println("==================================================");
		ArrayList<BedCounts> bedcount=showCurrentAvailableBeds();
		if(bedcount.size()!=0)
		{
			System.out.printf("%-15s %-10s %-10s %10s %10s%n", "Ward Id", "|", "Bed type", "|", "Number of Available beds");
			for(BedCounts bd:bedcount) {
				Ward w=bd.getWard();
				System.out.printf("%-15s %-10s %-10s %10s %10s%n", w.getWardId(), "|", bd.getBedType(), "|", bd.getNumberOfBeds());
			}


		}else {
			System.out.println("\t\t Currently no beds are available, Please try again later\t\t");
		}


	}



	@Override
	public void addNewWards() {

	}

	@Override
	public void checkPatientWiseBedDetails() {
		System.out.println("==================================================");
		System.out.println("\t\t\t\tPatient-wise Bed Details\t\t\t\t");
		System.out.println("==================================================");

		int wardId = -1;
		do {
			if (wardId == -1) {
				wardId = getSelectedWard();
				System.out.println(" Fetching Details... ");
			}
		} while (wardId == -1);

		if (wardId != -1) {
			ArrayList<PatientBed> patientBeds = getPatientBed(wardId);
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
		}
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
			ArrayList<Ward> result = getWardsList();
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
