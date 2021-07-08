package BusinessLogicLayer.AdminModule;

import java.util.Scanner;

public class ManageWards extends AddWards {

    public static void main(String args[]) throws Exception {

        ManageWards manage = new ManageWards();
        System.out.println("Press 1 to add Ward");
        System.out.println("Press 2 to update the ward details ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice){

            case 1:
                manage.addWards();
                break;
        }


    }
}
