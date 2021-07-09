package BusinessLogicLayer.AdmissionDischargeModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewAdmissionFormCreation {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;
    public static AdmissionDAO admissionDao = new AdmissionDAO();

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Admission admission = new Admission();
    public static LocalDate todayDate = LocalDate.now();


    public static void main(String args[]) throws Exception {
        NewAdmissionFormCreation admissionModule = new NewAdmissionFormCreation();
        admissionModule.admissionHomePage();
    }

    // admissionHomePage() method returns Admission module home page.
    public void admissionHomePage() throws Exception {
        int flag = 0;
        do {
            System.out.println("=================================================");
            System.out.println("\t\t\t\tMain Menu\t\t\t\t");
            System.out.println("=================================================");
            System.out.printf("%n");
            System.out.println("1. Admission Form");
            System.out.println("2. Discharge Form");
            System.out.println("3. Register New Patient.");
            System.out.println("4. Exit.");
            System.out.printf("%n");
            System.out.printf("Select number between 1-4 to perform appropriate action.");
            System.out.printf("%n");
            System.out.printf("Enter Selection : ");

            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if(choice > 0 && choice <=4){
                switch (choice) {
                    case 1:
                        admissionFormPage();flag=0;
                        break;
                    case 2:
                        dischargeFormPage();flag=0;
                        break;
                    case 3:
                        patientRegistrationPage();flag=0;
                        break;
                    case 4:
                        exitToMainPage();flag=0;
                }
            }else{
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
            }
        }while(flag==0);

        // Go to Application Main Page for Admission Discharge.
        // Insert Method Call here.
    }

    public void admissionFormPage() throws Exception {
        int flag=0;
        do {
            System.out.println("=================================================");
            System.out.println("\t\t\t\tAdmission Form\t\t\t\t");
            System.out.println("=================================================");
            System.out.printf("%n");
            System.out.println("1. Generate New Admission Form.");
            System.out.println("2. Update Existing Admission Form.");
            System.out.println("3. Go Back To Home Page.");
            System.out.printf("%n");
            System.out.println("Select number between 1-3 to perform appropriate action.");
            System.out.printf("%n");
            System.out.printf("Enter Selection : ");

            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            if(choice >0 && choice<=3)
            {
                switch (choice) {
                    case 1:
                        newAdmissionForm();flag=0;
                        break;
                    case 2:
                        updateAdmissionForm();flag=0;
                        break;
                    case 3:
                        flag=1; break;
                }
            }else{
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
            }
        }while(flag==0);
    }

    public void newAdmissionForm() throws Exception {

        Scanner userInput = new Scanner(System.in);

        String patientID = null;
        String patientName = null;
        String admissionType = null;
        String diseaseName = null;
        String doctorName = null;
        String wardCode = null;
        String bedCode = null;
        int flag = 0,flag1 = 0;
        int finalResult=0;

        System.out.println("==================================================");
        System.out.println("\t\t\t\tAdmission Form Page\t\t\t\t");
        System.out.println("==================================================");
        System.out.println("Please enter below details.");
        System.out.println("Note: * denotes mandatory details.");
        System.out.printf("%n");

        // Enter Patient ID.
        do {
            if (patientID == null) {
                try {
                    System.out.printf("1. Enter Patient ID\t\t: ");
                    patientID = userInput.nextLine();
                    patientName = admissionDao.getPatient(patientID);
                    if (patientName != null) {
                        flag = 1;
                        admission.setPatientID(patientID);
                    } else {
                        System.out.println("Entered Patient ID does not existing in the system. Please enter valid Patient ID.");
                        patientID = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (flag == 0);

        // Fetch Patient Name
        do {
            if (patientName != null) {
                System.out.print("2. Patient Name\t\t\t: " + patientName);
                System.out.printf("%n");
            }
        } while (patientName == null);

        // Enter Admission Type.
        do {
            if (admissionType == null) {
                try {
                    admissionType = displayAdmissionType();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (admissionType == null);

        //Enter Disease code.
        do {
            if (diseaseName == null) {
                diseaseName = displayDiagnose();
            }
        } while (diseaseName == null);

        //Enter Doctor Code.
        do{
            if (doctorName == null) {
                doctorName = displayDoctor();
            }
        }while (doctorName == null);

        //Enter Ward id.
        do{
            if(wardCode == null){
                wardCode = displayWard();
                System.out.println(wardCode);
            }
        }while(wardCode == null);

        //Enter Bed ID.
        do{
            if(bedCode == null){
                bedCode = displayBed();
                System.out.println(bedCode);
            }
        }while(bedCode == null);

        // Display Admission details for confirmation/Update
        if(patientID != null && patientName != null && admissionType != null && diseaseName != null && doctorName != null && wardCode != null && bedCode != null){
            do {
                    System.out.println("==================================================");
                    System.out.println("\t\t\t\tConfirm Admission Details.\t\t\t");
                    System.out.println("==================================================");
                    System.out.println("0. Patient Name    :\t"+patientName);
                    System.out.println("1. Patient ID      :\t"+patientID);
                    System.out.println("2. Admission Type  :\t"+admissionType);
                    System.out.println("3. Diagnose Code   :\t"+diseaseName);
                    System.out.println("4. Physician       :\t"+doctorName);
                    System.out.println("5. Ward            :\t"+wardCode);
                    System.out.println("6. Bed ID          :\t"+bedCode);
                    System.out.println("7. Admission Date  :\t"+todayDate);
                    System.out.println("8. Save Form");
                    System.out.println("9. Main Menu");
                    System.out.printf("%n");
                    System.out.println("To change or update the details please enter\n" +
                    "a associated number between 1-6. Select 8 to \n" +
                    "save the Admission form and 9 to return to \n" +
                    "Main Menu.");
                    System.out.printf("Enter Selection : ");

                    int result = userInput.nextInt();
                    if(result > 0 && result <=9)
                    {
                        switch (result) {
                            case 1: System.out.println("Enter Patient ID : ");
                                    userInput = new Scanner(System.in);
                                    patientID = userInput.nextLine();
                                    patientName = admissionDao.getPatient(patientID);
                                    admission.setPatientID(patientID);
                                    flag1 = 1;
                                    break;
                            case 2: admissionType = displayAdmissionType();
                                    flag1 = 1; break;
                            case 3: diseaseName = displayDiagnose();
                                    flag1 = 1; break;
                            case 4: doctorName = displayDoctor();
                                    flag1 = 1; break;
                            case 5: wardCode = displayWard();
                                    flag1 = 1; break;
                            case 6: bedCode = displayBed();
                                    flag1 = 1; break;
                            case 8: finalResult = admissionDao.saveAdmissionForm(admission);
                                    if(finalResult == 1) {
                                        System.out.println("Admission Form Created.");
                                    }
                                    else {
                                        System.out.println("Admission Form Creation Failed.");
                                    }
                                    flag1 = 0; break;
                            case 9: System.out.println("Go to Main page");
                                    flag1 =0;
                        }
                    }else{
                        System.out.printf("%n");
                        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                        System.out.printf("%n");
                        flag1 = 1;
                    }
                    }while(flag1 == 1);
                    // Go back to home page.
                }
    }

    public String displayAdmissionType() throws SQLException {
        int totalRow = 1,flag=0;
        String admissionType = null;
        String admissionTypeID;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("3. Select Admission Type from below options. ");
            ArrayList<String> result = admissionDao.getAdmissionTypesList();
            System.out.printf("%n");
            System.out.println("\t CODE | Type\t\t\t\n" + "==================================================");
            for (String type:result) {
                System.out.println("\t\t" + totalRow + " | " + type);
                totalRow++;
            }
            System.out.printf("%n");
            System.out.printf("Enter Selection\t\t: ");
            admissionTypeID = input.nextLine();
            totalRow--;
            String regex = "[1-" + totalRow + "]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(admissionTypeID);
            if (m.find()) {
                admissionType = admissionDao.getAdmissionType(Integer.parseInt(admissionTypeID));
                admission.setAdmissionType(Integer.parseInt(admissionTypeID));
                flag = 1;
            } else {
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
                totalRow=1;
            }
        }while(flag==0);
        return admissionType;
    }

    public String displayDiagnose() throws SQLException {

        int flag = 0;
        String diseaseName = null;
        do {
            int totalRows = 1;
            Scanner userInput = new Scanner(System.in);
            System.out.println("4. Select Disease Code from below options. ");
            ArrayList<String> result = admissionDao.getDiseaseList();
            System.out.printf("%n");
            System.out.println("\t CODE | Disease\t\t\t\n" + "==================================================");
            for (String disease:result) {
                System.out.println("\t\t" + totalRows + " | " + disease);
                totalRows++;
            }
            System.out.printf("%n");
            System.out.printf("Enter Selection\t\t: ");
            String diseaseID = userInput.nextLine();
            totalRows--;
            String regex = "[1-" + totalRows + "]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(diseaseID);
            if(m.find()) {
                diseaseName = admissionDao.getDiseaseName(Integer.parseInt(diseaseID));
                admission.setDiseaseID(Integer.parseInt(diseaseName));
                flag = 1;
            }
            else{
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
                totalRows=1;
            }
        }while(flag==0);
        return diseaseName;
    }

    public String displayDoctor() throws SQLException {
        int flag = 0;
        String doctorName = null;
        do {
            int totalRows = 1;
            Scanner userInput = new Scanner(System.in);
            System.out.println("5. Select Doctor Code from below options. ");
            // Fetch Doctors based on the Disease ID.
            ArrayList<String> result = admissionDao.getDoctorList();
            System.out.printf("%n");
            System.out.println("\t CODE | Doctor\t\t\t\n" + "==================================================");
            for (String doctor:result) {
                System.out.println("\t\t" + totalRows + " | Dr. " + doctor);
                totalRows++;
            }
            System.out.printf("%n");
            System.out.printf("Enter Selection\t\t: ");
            int docID = userInput.nextInt();
            totalRows--;
            if(docID<=totalRows && docID>0){
                doctorName = admissionDao.getDoctorName(docID);
                admission.setDoctorID(admissionDao.getDoctor(docID));
                flag = 1;
            }else{
                    System.out.printf("%n");
                    System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                    System.out.printf("%n");
                    totalRows=1;
            }
        }while(flag==0);
        return doctorName;
    }

    public String displayWard() throws SQLException {

        int flag = 0;
        String wardCode = null;
        int totalRows = 1;
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("6. Select Ward Code from below options. ");
            ArrayList<String> result = admissionDao.getWardsList();
            System.out.printf("%n");
            System.out.println("\t CODE | Ward Name\t\t\n" + "==================================================");
            for (String ward:result) {
                System.out.println("\t\t" + totalRows + " | " + ward);
                totalRows++;
            }
            System.out.printf("%n");
            System.out.printf("Enter Selection\t\t: ");
            String wardID = userInput.nextLine();
            totalRows--;
            String regex = "[1-" + totalRows + "]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(wardID);
            if(m.find()){
                wardCode = admissionDao.getWardCode(Integer.parseInt(wardID));
                admission.setWardID(Integer.parseInt(wardID));
                flag=1;
            }else{
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
                totalRows=1;
            }

        }while(flag==0);
        return wardCode;
    }

    public String displayBed() throws SQLException {

        int flag = 0;
        String bedCode = null;
        int totalRows = 1;
        do {
            Scanner userInput = new Scanner(System.in);
            System.out.println("7. Select Bed Code from below options. ");
            ArrayList<String> result = admissionDao.getAvailableBeds();
            System.out.printf("%n");
            System.out.println("\t CODE | Bed Code\t\t\n" + "==================================================");
            for (String bed:result) {
                System.out.println("\t\t" + totalRows + " | " +bed);
                totalRows++;
            }
            System.out.printf("%n");
            System.out.printf("Enter Selection\t\t: ");
            totalRows--;
            String bedID = userInput.nextLine();
            String regex = "[1-" + totalRows + "]";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bedID);
            if(m.find()){
                bedCode = admissionDao.getBedCode(Integer.parseInt(bedID));
                admission.setBedID(Integer.parseInt(bedID));
                flag=1;
            }
            else{
                System.out.printf("%n");
                System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                System.out.printf("%n");
                totalRows=1;
            }

        }while(flag==0);
        return bedCode;
    }

    // Enter Save Method here.

    public void updateAdmissionForm() throws Exception {

        int flag = 0;
        int formFlag = 0;
        String admissionType = null;
        String diseaseName  = null;
        String doctorName = null;
        String wardCode = null;
        String bedCode= null;
        int finalResult;
        do{
            Scanner userInput = new Scanner(System.in);
            System.out.printf("Enter Patient ID : ");
            String patientID = userInput.nextLine();
            boolean result = admissionDao.ifPatientExists(patientID);
            Admission updateUser;
            if(result){
                updateUser = admissionDao.getAdmissionDetails(patientID);
                if(!Objects.isNull(updateUser)){
                    do{
                        System.out.println("=================================================");
                        System.out.println("\t\t\t\t\tUpdate Form\t\t\t\t");
                        System.out.println("=================================================");
                        System.out.println("1. Patient ID      :\t"+updateUser.getPatientID());
                        System.out.println("2. Admission Type  :\t"+admissionDao.getAdmissionType(updateUser.getAdmissionType()));
                        System.out.println("3. Diagnose Code   :\t"+admissionDao.getDiseaseName(updateUser.getDiseaseID()));
                        System.out.println("4. Physician       :\t"+admissionDao.getDoctorName(updateUser.getDoctorID()));
                        System.out.println("5. Ward            :\t"+admissionDao.getWardCode(updateUser.getWardID()));
                        System.out.println("6. Bed ID          :\t"+admissionDao.getBedCode(updateUser.getBedID()));
                        System.out.println("7. Save Form       :\t");
                        System.out.println("8. Main Menu       :\t");
                        System.out.printf("%n");
                        System.out.println("To change or update the details please enter\n" +
                                "a associated number between 1-6. Select 8 to \n" +
                                "save the Admission form and 9 to return to \n" +
                                "Main Menu.");
                        System.out.printf("Enter Selection : ");

                        int userResponse = userInput.nextInt();
                        if(userResponse > 0 && userResponse <=8)
                        {
                            switch (userResponse) {
                                case 1: System.out.println("Enter Patient ID : ");
                                        userInput = new Scanner(System.in);
                                        patientID = userInput.nextLine();
                                        admission.setPatientID(patientID);
                                        formFlag = 1;
                                        break;
                                case 2: displayAdmissionType();
                                        updateUser.setAdmissionType(admission.getAdmissionType());
                                        formFlag = 1; break;
                                case 3: displayDiagnose();
                                        updateUser.setDiseaseID(admission.getDiseaseID());
                                        formFlag = 1; break;
                                case 4: displayDoctor();
                                        updateUser.setDoctorID(admission.getDoctorID());
                                        formFlag = 1; break;
                                case 5: displayWard();
                                        updateUser.setWardID(admission.getWardID());
                                        formFlag = 1; break;
                                case 6: displayBed(); updateUser.setBedID(admission.getBedID());
                                        formFlag = 1; break;
                                case 8: finalResult   = admissionDao.saveAdmissionForm(admission);
                                        if(finalResult == 1)
                                            System.out.println("Admission Form Saved Successfully.");
                                        else {
                                            System.out.println("Admission Form Update Failed.");
                                        }
                                        formFlag = 0; break;
                                case 9: System.out.println("Go to Main page");
                                        formFlag = 0;
                            }
                        }else{
                            System.out.printf("%n");
                            System.out.println("Invalid Input Received! Please Enter Valid Selection.");
                            System.out.printf("%n");
                            formFlag = 1;
                        }
                    }while(formFlag == 1);
                    flag = 1;
                } else {
                    System.out.println("Entered Patient does not have any Admission/Discharge records. Please enter other Patient ID.");
                }
            }else{
                System.out.println("Entered Patient ID does not existing in the system. Please enter valid Patient ID.");
            }
        }while(flag == 0);
        // Go back to Main menu.
    }

    public void dischargeFormPage() {

    }

    public void patientRegistrationPage(){

    }

    //Exit to main page of Hospital Management System.
    public void exitToMainPage(){

    }
}
