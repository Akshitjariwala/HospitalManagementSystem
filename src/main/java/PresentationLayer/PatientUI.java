package PresentationLayer;

import BusinessLogicLayer.PatientModule.BookAppointments;
import BusinessLogicLayer.PatientModule.UpdatePersonalDetails;

public class PatientUI {

    public void mainUI(String patientID,String patientName){

        UpdatePersonalDetails newPatient=new UpdatePersonalDetails();
        BookAppointments appointments=new BookAppointments();

        System.out.println("Welcome *******"+patientName+"*******\n\n");
    }

    public static void main(String[] args) {

    }
}
