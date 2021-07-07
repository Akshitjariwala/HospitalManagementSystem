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

import BusinessLogicLayer.Dao.RegisterDoctorDAO;

public class RegisterDoctor {
    String str = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
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
        System.out.println("Medical License Id* :");
        String medicalLicenseId = inputData.nextLine();
        doct.setMedicalLicenseId(medicalLicenseId);
        System.out.println("Last Name* :");
        String lastName = inputData.nextLine();
        doct.setLastName(lastName);
        System.out.println("Middle Name: ");
        String middleName = inputData.nextLine();
        doct.setMiddleName(middleName);
        System.out.println("First Name* :");
        String firstName = inputData.nextLine();
        doct.setFirstName(firstName);
        System.out.println("Email* :");
        String emailId = inputData.nextLine();
        doct.setEmailId(emailId);
        System.out.println("Phone number* :");
        String phoneNumber = inputData.nextLine();
        doct.setPhoneNumber(phoneNumber);
        System.out.println("Specialization*:");
        String specialization = inputData.nextLine();
        doct.setSpecialization(specialization);
        System.out.println("Department* :");
        String department = inputData.nextLine();
        doct.setDepartment(department);
        System.out.println("Experience* :");
        String experience = inputData.nextLine();
        doct.setExperience(experience);
        System.out.println("Password* :");
        String password = inputData.nextLine();
        doct.setPassword(password);
        System.out.println("Address* :");
        String address = inputData.nextLine();
        doct.setAddress(address);
        System.out.println("City* : ");
        String city = inputData.nextLine();
        doct.setCity(city);
        System.out.println("State* :");
        String state = inputData.nextLine();
        doct.setState(state);

        int status = RegisterDoctorDAO.addDoctor(doct);
        if(status ==1 )
        {
            System.out.println("Doctor details added successfully");
        }
        else
        {
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
        System.out.println("14. Save");
        System.out.println("15. Exit");
        System.out.println("Select a number from 1 to 13 to update any record. For any other action select 14 or 15");

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
            default:
                System.out.println("Invalid Input, Please choose either 1 or 2 ");
        }

        if(!str.isEmpty()){
            RegisterDoctorDAO.updateDoctor(str, doctorId );
        }

    }

}

