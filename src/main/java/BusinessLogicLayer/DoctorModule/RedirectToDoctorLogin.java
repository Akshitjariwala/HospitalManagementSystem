package BusinessLogicLayer.DoctorModule;

import BusinessLogicLayer.AdminModule.AddReports;

import java.util.Scanner;

public class RedirectToDoctorLogin {

    public static void redirectLogin() {

        System.out.println("*********WELCOME****************");
        System.out.println("1. Appointments");
        System.out.println("2. Patient List");
        System.out.println("3. Patient Reports");
        System.out.println("Please enter an option");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {

            case 1:
                //call appointments
                break;
            case 2:
                //call patients list
                break;
            case 3:
                //call patient reports
                break;
        }

    }
}
