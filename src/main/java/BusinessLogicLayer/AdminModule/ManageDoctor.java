/*
 * CSCI 5308 Group Project
 * @author: Sai Vaishnavi Jupudi
 * @description: This program handles doctor registration and updating the doctor details
 *
 * */
package BusinessLogicLayer.AdminModule;

import BusinessLogicLayer.BeanClasses.Doctor;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.ManageDoctor.IManageDoctorDAO;
import PresentationLayer.DoctorManagementUI;

import java.util.Scanner;

public class ManageDoctor extends AdminAbstractAction implements IManageDoctor {

  private IManageDoctorDAO iManageDoctorDAO;
  private static final String ACTION_TITLE = "Manage Doctor";

  public ManageDoctor() {
    iManageDoctorDAO = iAdminActionDatabase.manageDocDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  /* Doctor Details are taken as input
   * The details are stored into database
   */
  @Override
  public void registration() {
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
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getMedicalLicenseId() == null);

    do {
      System.out.println("Last Name* :");
      String lastName = inputData.nextLine();
      if (lastName.matches("[A-Za-z]*")) {
        doct.setLastName(lastName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getLastName() == null);

    do {
      System.out.println("Middle Name* :");
      String middleName = inputData.nextLine();
      if (middleName.matches("[A-Za-z]*")) {
        doct.setMiddleName(middleName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getMiddleName() == null);

    do {
      System.out.println("First Name* :");
      String firstName = inputData.nextLine();
      if (firstName.matches("[A-Za-z]*")) {
        doct.setFirstName(firstName);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getFirstName() == null);

    do {
      System.out.println("Email* :");
      String emailId = inputData.nextLine();
      if (emailId.matches("^(.+)@(.+)$")) {
        doct.setEmailId(emailId);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getEmailId() == null);

    do {
      System.out.println("Phone number* :");
      String phoneNumber = inputData.nextLine();
      if (phoneNumber.matches("\\d{10}")) {
        doct.setPhoneNumber(phoneNumber);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getPhoneNumber() == null);

    do {
      System.out.println("Specialization*:");
      String specialization = inputData.nextLine();
      if (specialization.matches("[A-Za-z]*")) {
        doct.setSpecialization(specialization);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getSpecialization() == null);

    do {
      System.out.println("Department* :");
      String department = inputData.nextLine();

      if (department.matches("[A-Za-z]*")) {
        doct.setDepartment(department);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getDepartment() == null);


    do {
      System.out.println("Experience* :");
      String experience = inputData.nextLine();
      if (experience.matches("^[0-9]*$")) {
        doct.setExperience(experience);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getExperience() == null);

    do {
      System.out.println("Password* :");
      String password = inputData.nextLine();

      if (password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" +
              "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$")) {
        doct.setPassword(password);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getPassword() == null);


    System.out.println("Address* :");
    String address = inputData.nextLine();
    doct.setAddress(address);

    do {
      System.out.println("City* : ");
      String city = inputData.nextLine();

      if (city.matches("[A-Za-z]*")) {
        doct.setCity(city);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getCity() == null);

    do {
      System.out.println("State* :");
      String state = inputData.nextLine();
      if (state.matches("[A-Za-z]*")) {
        doct.setState(state);
      } else {
        System.out.println("Please enter valid input:");
      }
    } while (doct.getState() == null);

    int status = iManageDoctorDAO.addDoctor(doct);
    if (status == 1) {
      System.out.println("Doctor details added successfully");
    } else {
      System.out.println("ERROR while adding details");
    }
    DoctorManagementUI doctorManagementUI = new DoctorManagementUI();
    doctorManagementUI.adminDoctorPage();
  }

  /* The details of the doctor can be updated
   * An input for the id is taken for which the details are needed to be updated
   * The details are fetched from database and are displayed
   * The user will have privilege to edit the details and the details are updated in database
   */
  @Override
  public void updateRegistration() {
    String str = "";

    System.out.print("\nEnter Doctor Id : ");

    Scanner scanner = new Scanner(System.in);

    String doc_id = scanner.next();

    Doctor doct1 = iManageDoctorDAO.getDoctor(doc_id);
    int doctorId = doct1.getId();
    System.out.println("\n1. Medical License Id* :" + doct1.getMedicalLicenseId());
    System.out.println("2. Password* :" + doct1.getPassword());
    System.out.println("3. Last Name* :" + doct1.getLastName());
    System.out.println("4. First Name* :" + doct1.getFirstName());
    System.out.println("5. Middle Name:" + doct1.getMiddleName());
    System.out.println("6. Email* :" + doct1.getEmailId());
    System.out.println("7. Phone number* :" + doct1.getPhoneNumber());
    System.out.println("8. Address* :" + doct1.getAddress());
    System.out.println("9. City* : " + doct1.getCity());
    System.out.println("10. State* :" + doct1.getState());
    System.out.println("11. Experience* :" + doct1.getExperience());
    System.out.println("12. Specialization*:" + doct1.getSpecialization());
    System.out.println("13. Department* :" + doct1.getSpecialization());
    System.out.println("14. Exit");
    System.out.print("Select a number from 1 to 13 to update any record. For exit select 14 : ");

    int input = scanner.nextInt();

    switch (input) {
      case 1:
        String medical;
        do {
          System.out.println("Medical License Id* :");
          medical = scanner.next();
          if (medical.matches("^[a-zA-Z0-9_.-]*$")) {
            str = "doc_id = " + medical;
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (medical == null);
        break;
      case 2:
        String password;
        do {
          System.out.println("Enter Password :");
          password = scanner.nextLine();
          if (password.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" +
                  "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$")) {
            str = "password = " + password;
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (password == null);

        break;
      case 3:
        String lastName;
        do {
          System.out.println("Enter Last Name :");
          lastName = scanner.nextLine();
          if (lastName.matches("[A-Za-z]*")) {
            str = "last_name = " + "'" + lastName + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (lastName == null);
        break;
      case 4:
        String firstName;
        do {
          System.out.println("Enter First Name :");
          firstName = scanner.next();
          if (firstName.matches("[A-Za-z]*")) {
            str = "first_name = " + "'" + firstName + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (firstName == null);

        break;
      case 5:
        System.out.println("Enter Middle Name :");
        String middleName = scanner.next();
        str = "middle_name = " + "'" + middleName + "'";
        break;
      case 6:
        String email;
        do {
          System.out.println("Enter email :");
          email = scanner.next();
          if (email.matches("^(.+)@(.+)$")) {
            str = "email = " + "'" + email + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (email == null);
        break;
      case 7:
        String phoneNumber;
        do {
          System.out.println("Enter Phone Number :");
          phoneNumber = scanner.next();
          if (phoneNumber.matches("\\d{10}")) {
            str = "phone_number = " + phoneNumber;
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (phoneNumber == null);
        break;
      case 8:
        System.out.println("Enter Address :");
        String address = scanner.next();
        str = "address = " + "'" + address + "'";
        break;
      case 9:
        String city;
        do {
          System.out.println("Enter City :");
          city = scanner.next();
          if (city.matches("[A-Za-z]*")) {
            str = "city = " + "'" + city + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (city == null);
        break;
      case 10:
        String state;
        do {
          System.out.println("Enter State :");
          state = scanner.next();
          if (state.matches("[A-Za-z]*")) {
            str = "state = " + "'" + state + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (state == null);
        break;

      case 11:
        String experience;
        do {
          System.out.println("Enter Experience :");
          experience = scanner.next();
          if (experience.matches("^[0-9]*$")) {
            str = "experience_years = " + experience;
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (experience == null);
        break;
      case 12:
        String specialization;
        do {
          System.out.println("Enter Specialization :");
          specialization = scanner.next();
          if (specialization.matches("[A-Za-z]*")) {
            str = "specialization = " + "'" + specialization + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (specialization == null);
        break;
      case 13:
        String department;
        do {
          System.out.println("Enter Department :");
          department = scanner.next();
          if (department.matches("[A-Za-z]*")) {
            str = "department = " + "'" + department + "'";
          } else {
            System.out.println("Please enter valid input:");
          }
        } while (department == null);
        break;
      case 14:
        DoctorManagementUI doctorManagementUI = new DoctorManagementUI();
        doctorManagementUI.adminDoctorPage();
        break;
      default:
        System.out.println("Invalid Input, Please select valid number ");
    }
    if (!str.isEmpty()) {
      iManageDoctorDAO.updateDoctor(str, doctorId);
      System.out.println("Doctor details updated successfully");
      DoctorManagementUI doctorManagementUI = new DoctorManagementUI();
      doctorManagementUI.adminDoctorPage();
    }
  }

}
