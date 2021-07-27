/*
 * CSCI 5308 Group Project
 * @author: Akshit Jariwala
 * @description: This Module handles Admission functionality
 * It creates a new admission records for the patient which can be
 * updated. It allocates resources to the patient based on availability.
 * It also handles the discharge of the Patient and release of resources.
 */

package BusinessLogicLayer.AdmissionDischargeModule;

import BusinessLogicLayer.BeanClasses.Admission;
import DatabaseLayer.ActionDatabase.Admin.AdminAbstractAction;
import DatabaseLayer.ActionDatabase.Admin.AdmissionDischarge.*;
import PresentationLayer.AdmissionFormUI;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class AdmissionForm extends AdminAbstractAction implements IAdmissionForm {

  public static IAdmissionDetailsDAO getAdmissionDetailsDao;
  public static IAdmissionFormDAO saveAdmissionDao;
  public static IAdmissionTypeDAO admissionTypeDAO;
  public static IBedAdmissionDAO bedAdmissionDAO;
  public static IDiseaseDAO diseaseDAO;
  public static IDoctorDAO doctorDAO;
  public static IPatientDAO patientDAO;
  public static IWardAdmissionDAO wardDAO;
  public static AdmissionFormUI admissionUI = new AdmissionFormUI();
  public static Admission admission = new Admission();
  public static LocalDate todayDate = LocalDate.now();
  private static final String ACTION_TITLE = "Admission Form";

  public AdmissionForm(){
    saveAdmissionDao = iAdminActionDatabase.saveAdmissionForm();
    getAdmissionDetailsDao = iAdminActionDatabase.admissionDetailsDAO();
    admissionTypeDAO = iAdminActionDatabase.admissionTypeDAO();
    bedAdmissionDAO = iAdminActionDatabase.bedAdmissionDAO();
    diseaseDAO = iAdminActionDatabase.diseaseDAO();
    doctorDAO = iAdminActionDatabase.doctorDAO();
    patientDAO = iAdminActionDatabase.patientDAO();
    wardDAO = iAdminActionDatabase.wardAdmissionDAO();
  }

  @Override
  public String getActionTitle() {
    return ACTION_TITLE;
  }

  @Override
  public void newAdmissionForm() {

    Scanner userInput = new Scanner(System.in);
    String patientName = null;
    String admissionType = null;
    String diseaseName = null;
    String doctorName = null;
    String wardCode = null;
    String bedCode = null;
    int flag1 = 0;
    int finalResult;

    System.out.println("\n==================================================");
    System.out.println("\t\t\t\tAdmission Form Page\t\t\t\t");
    System.out.println("==================================================");
    System.out.println("Please enter below details.");
    System.out.println("Note: * denotes mandatory details.");

    do {
      try {
        patientName = displayPatientName();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (patientName == null);

    System.out.print("2. Patient Name\t\t\t: " + patientName);
    System.out.printf("%n");

    do {
      try {
        admissionType = displayAdmissionType();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (admissionType == null);

    do {
      try {
        diseaseName = displayDiagnose();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (diseaseName == null);

    do {
      try {
        doctorName = displayDoctor();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (doctorName == null);

    do {
      try {
        wardCode = displayWard();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (wardCode == null);

    do {
      try {
        bedCode = displayBed();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } while (bedCode == null);

    if (admission.getPatientID() != null) {
      do {
        System.out.println("\n==================================================");
        System.out.println("\t\t\t\tConfirm Admission Details.\t\t\t");
        System.out.println("==================================================");

        System.out.println("0. Patient Name    :\t" + patientName);
        System.out.println("1. Patient ID      :\t" + admission.getPatientID());
        System.out.println("2. Admission Type  :\t" + admissionType);
        System.out.println("3. Diagnose Code   :\t" + diseaseName);
        System.out.println("4. Physician       :\t" + doctorName);
        System.out.println("5. Ward            :\t" + wardCode);
        System.out.println("6. Bed ID          :\t" + bedCode);
        System.out.println("7. Admission Date  :\t" + todayDate);
        System.out.println("8. Save Form");
        System.out.println("9. Main Menu");
        System.out.print("\nTo change or update the details please enter" +
            "a associated number between 1-6.\nSelect 8 to" +
            " save the Admission form and 9 to return to the " +
            "Admission/Discharge Home Page.\n\nEnter Selection : ");

        int result = userInput.nextInt();
        if (result > 0 && result <= 9) {
          switch (result) {
            case 1:
              patientName = displayPatientName();
              flag1 = 1;
              break;
            case 2:
              admissionType = displayAdmissionType();
              flag1 = 1;
              break;
            case 3:
              diseaseName = displayDiagnose();
              flag1 = 1;
              break;
            case 4:
              doctorName = displayDoctor();
              flag1 = 1;
              break;
            case 5:
              wardCode = displayWard();
              flag1 = 1;
              break;
            case 6:
              bedCode = displayBed();
              flag1 = 1;
              break;
            case 8:
              try {
                finalResult = saveAdmissionDao.saveAdmissionForm(admission);
                if (finalResult == 1) {
                  System.out.println("Admission Created Successfully.");
                } else {
                  System.out.println("\nAdmission Form Creation Failed.");
                }
                flag1 = 0;
                break;
              } catch (SQLException throwables) {
                throwables.printStackTrace();
              }
            case 9:
              admissionUI.admissionHomePage();
              flag1 = 0;
          }
        } else {
          System.out.printf("%n");
          System.out.println("Invalid Input Received! Please Enter Valid Selection.");
          flag1 = 1;
        }
      } while (flag1 == 1);
    }
  }

  @Override
  public String displayPatientName() {
    String patientName = null;
    int flag = 0;
    do {
      System.out.print("\n1. Enter Patient ID\t\t:");
      Scanner res;
      res = new Scanner(System.in);
      String patientID = res.nextLine();
      boolean b;
      try {
        b = patientDAO.ifPatientExists(patientID);
      if (b) {
        patientName = patientDAO.getPatient(patientID);
        admission.setPatientID(patientID);
        flag = 1;
      } else {
        System.out.println("\nEntered Patient ID does not existing in the system. Please Select Valid Option From Below.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } while (flag == 0);

    return patientName;
  }

  @Override
  public String displayAdmissionType() {
    int flag = 0;
    String admissionType = null;
    int admissionTypeID;
    do {
      Scanner input = new Scanner(System.in);
      System.out.println("\n3. Select Admission Type from below options. ");
      Map<Integer, String> result;
      try {
        result = admissionTypeDAO.getAdmissionTypesList();
      System.out.printf("%n");
      System.out.println("\t CODE | Type\t\t\t\n" + "==================================================");
      for (Map.Entry m : result.entrySet()) {
        System.out.println("\t\t" + m.getKey() + " | " + m.getValue());
      }
      System.out.print("\nEnter Selection\t\t: ");
      admissionTypeID = input.nextInt();
      if (result.containsKey(admissionTypeID)) {
        admissionType = admissionTypeDAO.getAdmissionType(admissionTypeID);
        admission.setAdmissionType(admissionTypeID);
        flag = 1;
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } while (flag == 0);
    return admissionType;
  }

  @Override
  public String displayDiagnose() {
    int flag = 0;
    String diseaseName = null;
    do {
      Scanner userInput = new Scanner(System.in);
      System.out.println("\n4. Select Disease Code from below options. ");
      Map<Integer, String> result;
      try {
        result = diseaseDAO.getDiseaseList();
      System.out.printf("%n");
      System.out.println("\t CODE | Disease\t\t\t\n" + "==================================================");
      for (Map.Entry m : result.entrySet()) {
        System.out.println("\t\t" + m.getKey() + " | " + m.getValue());
      }
      System.out.print("\nEnter Selection\t\t: ");
      int diseaseID = userInput.nextInt();
      if (result.containsKey(diseaseID)) {
        diseaseName = diseaseDAO.getDiseaseName(diseaseID);
        admission.setDiseaseID(diseaseID);
        flag = 1;
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } while (flag == 0);
    return diseaseName;
  }

  @Override
  public String displayDoctor() {
    int flag = 0;
    String doctorName = null;
    do {
      Scanner userInput = new Scanner(System.in);
      System.out.println("\n5. Select Doctor Code from below options. ");
      Map<Integer, String> result;
      try {
        result = doctorDAO.getDoctorList();
      System.out.printf("%n");
      System.out.println("\t CODE | Doctor\t\t\t\n" + "==================================================");
      for (Map.Entry m : result.entrySet()) {
        System.out.println("\t\t" + m.getKey() + " | Dr. " + m.getValue());
      }
      System.out.print("\nEnter Selection\t\t: ");
      int docID = userInput.nextInt();
      if (result.containsKey(docID)) {
        doctorName = doctorDAO.getDoctorName(docID);
        admission.setDoctorID(doctorDAO.getDoctor(docID));
        flag = 1;
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    } while (flag == 0);
    return doctorName;
  }

  @Override
  public String displayWard() {

    int flag = 0;
    String wardCode = null;
    do {
      Scanner userInput = new Scanner(System.in);
      System.out.println("\n6. Select Ward Code from below options. ");
      Map<Integer, String> result;
      try {
        result = wardDAO.getWardsList();
      System.out.printf("%n");
      System.out.println("\t CODE | Ward Name\t\t\n" + "==================================================");
      for (Map.Entry m : result.entrySet()) {
        System.out.println("\t\t" + m.getKey() + " | " + m.getValue());
      }
      System.out.print("\nEnter Selection\t\t: ");
      int wardID = userInput.nextInt();
      if (result.containsKey(wardID)) {
        wardCode = wardDAO.getWardCode(wardID);
        admission.setWardID(wardID);
        flag = 1;
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }

    } while (flag == 0);
    return wardCode;
  }

  @Override
  public String displayBed() {

    int flag = 0;
    String bedCode = null;
    do {
      Scanner userInput = new Scanner(System.in);
      System.out.println("\n7. Select Bed Code from below options. ");
      Map<Integer, String> result;
      try {
        result = bedAdmissionDAO.getAvailableBeds();
      System.out.printf("%n");
      System.out.println("\t CODE | Bed Code\t\t\n" + "==================================================");
      for (Map.Entry m : result.entrySet()) {
        System.out.println("\t\t" + m.getKey() + " | " + m.getValue());
      }
      System.out.print("\nEnter Selection\t\t: ");
      int bedID = userInput.nextInt();
      if (result.containsKey(bedID)) {
        bedCode = bedAdmissionDAO.getBedCode(bedID);
        admission.setBedID(bedID);
        flag = 1;
      } else {
        System.out.printf("%n");
        System.out.println("Invalid Input Received! Please Enter Valid Selection.");
      }
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }

    } while (flag == 0);
    return bedCode;
  }

  @Override
  public void updateAdmissionForm() {

    int flag = 0;
    int formFlag = 0;
    int finalResult;
    do {
      Scanner userInput = new Scanner(System.in);
      System.out.print("\nEnter Patient ID  : ");
      String patientID = userInput.nextLine();
      boolean result = false;
      try {
        result = patientDAO.ifPatientExists(patientID);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
      Admission updateUser = new Admission();
      if (result) {
        try {
          updateUser = getAdmissionDetailsDao.getAdmissionDetails(patientID);
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
        if (!Objects.isNull(updateUser)) {
          do {
            try {
              System.out.println("\n=================================================");
              System.out.println("\t\t\t\t\tUpdate Form\t\t\t\t");
              System.out.println("=================================================");
              System.out.println("1. Patient ID      :\t" + updateUser.getPatientID());
              System.out.println("2. Admission Type  :\t" + admissionTypeDAO.getAdmissionType(updateUser.getAdmissionType()));
              System.out.println("3. Diagnose Code   :\t" + diseaseDAO.getDiseaseName(updateUser.getDiseaseID()));
              System.out.println("4. Physician       :\t" + doctorDAO.getDoctorName(updateUser.getDoctorID()));
              System.out.println("5. Ward            :\t" + wardDAO.getWardCode(updateUser.getWardID()));
              System.out.println("6. Bed ID          :\t" + bedAdmissionDAO.getBedCode(updateUser.getBedID()));
              System.out.println("7. Save Form\t");
              System.out.println("8. Main Menu\t");
              System.out.print("\nTo change or update the details please enter" +
                  "a associated number between 1-6.\nSelect 7 to " +
                  "save the Admission form and 8 to return to " +
                  "Main Menu.\n\nEnter Selection : ");
            } catch(SQLException throwables){
              throwables.printStackTrace();
            }
            int userResponse = userInput.nextInt();
            if (userResponse > 0 && userResponse <= 9) {
              switch (userResponse) {
                case 1:
                  System.out.println("Enter Patient ID : ");
                  userInput = new Scanner(System.in);
                  patientID = userInput.nextLine();
                  admission.setPatientID(patientID);
                  formFlag = 1;
                  break;
                case 2:
                  displayAdmissionType();
                  updateUser.setAdmissionType(admission.getAdmissionType());
                  formFlag = 1;
                  break;
                case 3:
                  displayDiagnose();
                  updateUser.setDiseaseID(admission.getDiseaseID());
                  formFlag = 1;
                  break;
                case 4:
                  displayDoctor();
                  updateUser.setDoctorID(admission.getDoctorID());
                  formFlag = 1;
                  break;
                case 5:
                  displayWard();
                  updateUser.setWardID(admission.getWardID());
                  formFlag = 1;
                  break;
                case 6:
                  displayBed();
                  updateUser.setBedID(admission.getBedID());
                  formFlag = 1;
                  break;
                case 7:
                  try {
                    finalResult = saveAdmissionDao.updateAdmissionForm(updateUser);
                    if (finalResult == 1)
                      System.out.println("\nAdmission Form Saved Successfully.");
                    else {
                      System.out.println("\nAdmission Form Update Failed.");
                    }
                    formFlag = 0;
                    break;
                  } catch (SQLException throwables) {
                    throwables.printStackTrace();
                  }
                case 8:
                  try {
                    admissionUI.admissionHomePage();
                  } catch (Exception e) {
                    e.printStackTrace();
                  }
                  formFlag = 0;
              }
            } else {
              System.out.printf("%n");
              System.out.println("Invalid Input Received! Please Enter Valid Selection.");
              formFlag = 1;
            }
          } while (formFlag == 1);
          flag = 1;
        } else {
          System.out.println("Entered Patient does not have any Admission/Discharge records. Please enter other Patient ID.");
        }
      } else {
        System.out.println("Entered Patient ID does not existing in the system. Please enter valid Patient ID.");
      }
    } while (flag == 0);
  }
}
