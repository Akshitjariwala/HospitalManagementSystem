/*
 * CSCI 5308 Group Project
 * @author: Akshit Jariwala
 * @description: This Module handles Admission/Discharge form.
 * It shows the main menu for the Admission/ Discharge.
 */

package PresentationLayer;

import BusinessLogicLayer.AdmissionDischargeModule.AdmissionForm;
import BusinessLogicLayer.AdmissionDischargeModule.DischargeForm;
import BusinessLogicLayer.AdmissionDischargeModule.IAdmissionForm;
import BusinessLogicLayer.AdmissionDischargeModule.IDischargeForm;
import BusinessLogicLayer.PatientModule.PatientRegistration;
import java.util.Scanner;

public class AdmissionFormUI {
    
    public static IDischargeForm IDischargeForm = new DischargeForm();
    public static IAdmissionForm newAdmission = new AdmissionForm();
    public void admissionHomePage() {
        int flag = 0;
        do {
            System.out.println("\n=================================================");
            System.out.println("\t\t\t\tAdmission/Discharge Home Page\t\t\t\t");
            System.out.println("=================================================");
            System.out.printf("%n");
            System.out.println("1. Admission Form");
            System.out.println("2. Discharge Form");
            System.out.println("3. Register New Patient.");
            System.out.println("4. Go to Admin Home Page");
            System.out.print("\nSelect number between 1-4 to perform appropriate action.\n\nEnter Selection : ");
            
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if (choice > 0 && choice <= 4) {
                switch (choice) {
                    case 1:
                        try {
                            admissionFormPage();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        flag = 0;
                        break;
                    case 2:
                        IDischargeForm.dischargeForm();
                        flag = 0;
                        break;
                    case 3:
                        PatientRegistration patientRegistration = new PatientRegistration();
                        patientRegistration.newPatientRegistration();
                        flag = 0;
                        break;
                    case 4:
                        AdminUI al = new AdminUI();
                        try {
                            al.adminPage();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } else {
                System.out.println("\nInvalid Input Received! Please Enter Valid Selection.\n");
            }
        } while (flag == 0);
    }
    
    public void admissionFormPage() {
        int flag = 0;
        do {
            System.out.println("\n=================================================");
            System.out.println("\t\t\t\tAdmission Form\t\t\t\t");
            System.out.println("=================================================");
            System.out.printf("%n");
            System.out.println("1. Generate New Admission Form.");
            System.out.println("2. Update Existing Admission Form.");
            System.out.println("3. Go Back To Previous menu.");
            System.out.print("\nSelect number between 1-3 to perform appropriate action.\n\nEnter Selection : ");
            
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if (choice > 0 && choice <= 3) {
                switch (choice) {
                    case 1:
                        try {
                            newAdmission.newAdmissionForm();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        flag = 0;
                        break;
                    case 2:
                        newAdmission.updateAdmissionForm();
                        flag = 0;
                        break;
                    case 3:
                        flag = 1;
                        break;
                }
            } else {
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
            }
        } while (flag == 0);
    }
}
