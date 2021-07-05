package BusinessLogicLayer.WardModule;

import java.util.Scanner;

public class WardHome {
    public static void main(String[] args) {
        WardHome wardHome = new WardHome();
        wardHome.wardManageHomePage();
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
            System.out.println("2. Show bed Availability");
            System.out.println("3. Patient-wise bed details");
            System.out.println("4. Main Menu");
            System.out.println("5. Exit");
            System.out.printf("%n");
            System.out.print("Select number between 1-5 to perform appropriate action.");
            System.out.printf("%n");
            System.out.print("Enter Selection : ");

            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if (choice > 0 && choice <= 4) {
                switch (choice) {
                    case 1:
                        addNewWards();// call add new wards method here
                        flag = 1;
                        break;
                    case 2:
                        checkBedAvailability();// call check bed availability method here
                        flag = 1;
                        break;
                    case 3:
                        checkPatientWiseBedDetails();// call patient-wise bed details method here
                        flag = 1;
                        break;
                    case 4:
                        // call main menu
                        flag = 1;
                    case 5:
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

    public void checkBedAvailability() {

    }

    public void addNewWards() {

    }

    public void checkPatientWiseBedDetails() {

    }

}
