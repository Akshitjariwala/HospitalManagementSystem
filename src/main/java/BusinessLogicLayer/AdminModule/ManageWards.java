package BusinessLogicLayer.AdminModule;

import java.sql.SQLException;
import java.util.Scanner;
import BusinessLogicLayer.AdminModule.UpdateWards;
import BusinessLogicLayer.AdminModule.AddWards;

public class ManageWards extends AddWards {

    public void manageWards(){

        //ManageWards manage = new ManageWards();
        System.out.println("Press 1 to add Ward");
        System.out.println("Press 2 to update the ward details ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        try {
            switch (choice) {
                case 1:
                    AddWards.addWards();
                    break;
                case 2:
                    UpdateWards.updateWards();
                    break;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
        }
    }
}
