package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Reports;
import BusinessLogicLayer.AdminModule.AddReports;
import java.util.Scanner;

public class CreateLabReports {

    public static void main(String args[]) throws Exception {
        System.out.println("Press 1 to add Reports");
        System.out.println("Press 2 to update the Reports ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {

            case 1:
                AddReports.addReports();
                break;

        }
    }
}
