package BusinessLogicLayer.AdminModule;

import java.util.Scanner;
import BusinessLogicLayer.AdminModule.UpdateWards;
import BusinessLogicLayer.AdminModule.AddWards;

public class ManageWards extends AddWards {

    public static void main(String args[]) throws Exception {

        //ManageWards manage = new ManageWards();
        System.out.println("Press 1 to add Ward");
        System.out.println("Press 2 to update the ward details ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice){

            case 1:
                AddWards.addWards();
                break;

            case 2:
                UpdateWards.updateWards();
                break;


        }


    }
}
