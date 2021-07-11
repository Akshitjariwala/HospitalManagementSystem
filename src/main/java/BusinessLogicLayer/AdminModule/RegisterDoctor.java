/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Doctor;

import java.sql.SQLException;
import java.util.Scanner;

import DatabaseLayer.Dao.RegisterDoctorDAO;

public class RegisterDoctor {
    String str = "";

    public static void registerDoctor() throws SQLException, ClassNotFoundException {
        RegisterDoctor registration = new RegisterDoctor();
        System.out.println("Press 1 to register");
        System.out.println("Press 2 to update the records ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        // Action performed based on input choice
        if(choice == 1){
            registration.Registration();
        }
        else if(choice == 2){
            registration.UpdateRegistration();
        }
        else{
            System.out.println("Invalid Input, Please choose either 1 or 2 ");
        }
    }

    /* Doctor Details are taken as input
     * The details are stored into database
     */
    public void Registration (){

        Doctor doct = new Doctor();
        Scanner inputData = new Scanner(System.in);
        System.out.println("============================================================================");
        System.out.println("                      Doctor Registration");
        System.out.println("============================================================================");
        System.out.println("Please enter the below details");
        System.out.println("Note: * denotes mandatory fields");

        do {
            System.out.println("Medical License Id* :");
            String medicalLicenseId = inputData.nextLine();
            if (medicalLicenseId.matches("^[a-zA-Z0-9_.-]*$")) {
                doct.setMedicalLicenseId(medicalLicenseId);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getMedicalLicenseId() == null);

        do {
            System.out.println("Last Name* :");
            String lastName = inputData.nextLine();
            if (lastName.matches("[A-Za-z]*")) {
                doct.setLastName(lastName);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getLastName() == null);

        do {
            System.out.println("Middle Name* :");
            String middleName = inputData.nextLine();
            if (middleName.matches("[A-Za-z]*")) {
                doct.setMiddleName(middleName);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getMiddleName() == null);

        do {
            System.out.println("First Name* :");
            String firstName = inputData.nextLine();
            if (firstName.matches("[A-Za-z]*")) {
                doct.setFirstName(firstName);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getFirstName() == null);

        do {
            System.out.println("Email* :");
            String emailId = inputData.nextLine();
            if (emailId.matches("^(.+)@(.+)$")) {
                doct.setEmailId(emailId);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getEmailId() == null);

        do {
            System.out.println("Phone number* :");
            String phoneNumber = inputData.nextLine();
            if (phoneNumber.matches("\\d{10}")) {
                doct.setPhoneNumber(phoneNumber);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getPhoneNumber() == null);

        do {
            System.out.println("Specialization*:");
            String specialization = inputData.nextLine();
            if (specialization.matches("[A-Za-z]*")) {
                doct.setSpecialization(specialization);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getSpecialization() == null);

        do {
            System.out.println("Department* :");
            String department = inputData.nextLine();

            if (department.matches("[A-Za-z]*")) {
                doct.setDepartment(department);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getDepartment() == null);


        do {
            System.out.println("Experience* :");
            String experience = inputData.nextLine();
            if (experience.matches("^[0-9]*$")) {
                doct.setExperience(experience);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getExperience() == null);

        do {
            System.out.println("Password* :");
            String password = inputData.nextLine();

            if (password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" +
                    "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$")) {
                doct.setPassword(password);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getPassword() == null);


        System.out.println("Address* :");
        String address = inputData.nextLine();
        doct.setAddress(address);

        do {
            System.out.println("City* : ");
            String city = inputData.nextLine();

            if (city.matches("[A-Za-z]*")) {
                doct.setCity(city);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getCity() == null);

        do {
            System.out.println("State* :");
            String state = inputData.nextLine();
            if (state.matches("[A-Za-z]*")) {
                doct.setState(state);
            }else{
                System.out.println("Please enter valid input:");
            }
        }while (doct.getState() == null);

        int status = RegisterDoctorDAO.addDoctor(doct);
        if(status ==1 ) {
            System.out.println("Doctor details added successfully");
        } else {
            System.out.println("ERROR while adding details");
        }
    }

    /* The details of the doctor can be updated
     * An input for the id is taken for which the details are needed to be updated
     * The details are fetched from database and are displayed
     * The user will have privilege to edit the details and the details are updated in database
     */
    public void UpdateRegistration() throws SQLException, ClassNotFoundException {
        System.out.println("Enter doctor id");

        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        Doctor doct1 = RegisterDoctorDAO.getDoctor(id);
        int doctorId = doct1.getId();
        System.out.println("1.  Medical License Id* :" + doct1.getMedicalLicenseId());
        System.out.println("2.  Password* :" + doct1.getPassword());
        System.out.println("3.  Last Name* :" + doct1.getLastName());
        System.out.println("4.  First Name* :"+ doct1.getFirstName());
        System.out.println("5.  Middle Name:" + doct1.getMiddleName() );
        System.out.println("6.  Email* :" + doct1.getEmailId());
        System.out.println("7.  Phone number* :" + doct1.getPhoneNumber());
        System.out.println("8.  Address* :" + doct1.getAddress());
        System.out.println("9.  City* : " + doct1.getCity());
        System.out.println("10. State* :" + doct1.getState());
        System.out.println("11. Experience* :" + doct1.getExperience());
        System.out.println("12. Specialization*:" + doct1.getSpecialization());
        System.out.println("13. Department* :" + doct1.getSpecialization());
        System.out.println("14. Exit");
        System.out.println("Select a number from 1 to 13 to update any record. For exit select 14");

        int input = scanner.nextInt();

        switch (input) {
            case 1:
                System.out.println("Enter medical license id :");
                String medical = scanner.next();
                str = "doc_id = " + medical ;
                break;
            case 2:
                System.out.println("Enter Password :");
                String password = scanner.next();
                str = "password = " + password ;
                break;
            case 3:
                System.out.println("Enter Last Name :");
                String lastName = scanner.next();
                str = "last_name = " + "'" + lastName + "'" ;
                break;
            case 4:
                System.out.println("Enter First Name :");
                String firstName = scanner.next();
                str = "first_name = " + "'" + firstName + "'" ;
                break;
            case 5:
                System.out.println("Enter Middle Name :");
                String middleName = scanner.next();
                str = "middle_name = " + "'" + middleName + "'" ;
                break;
            case 6:
                System.out.println("Enter email :");
                String email = scanner.next();
                str = "email = " + "'" + email + "'" ;
                break;
            case 7:
                System.out.println("Enter Phone Number :");
                String phoneNumber = scanner.next();
                str = "phone_number = " + phoneNumber ;
                break;
            case 8:
                System.out.println("Enter Address :");
                String address = scanner.next();
                str = "address = " + "'" + address + "'";
                break;
            case 9:
                System.out.println("Enter City :");
                String city = scanner.next();
                str = "city = " + "'" + city + "'";
                break;
            case 10:
                System.out.println("Enter State :");
                String state = scanner.next();
                str = "state = " + "'" +  state + "'" ;
                break;
            case 11:
                System.out.println("Enter Experience :");
                String experience = scanner.next();
                str = "experience_years = " + experience ;
                break;
            case 12:
                System.out.println("Enter Specialization :");
                String specialization = scanner.next();
                str = "specialization = " + "'" + specialization + "'";
                break;
            case 13:
                System.out.println("Enter Department :");
                String department = scanner.next();
                str = "department = " + "'" + department + "'";
                break;
            case 14:
                break;
            default:
                System.out.println("Invalid Input, Please select valid number ");
        }

        if(!str.isEmpty()){
            RegisterDoctorDAO.updateDoctor(str, doctorId );
        }

    }

}

