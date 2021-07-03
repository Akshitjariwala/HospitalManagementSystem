package BusinessLogicLayer.AdmissionDischargeModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;

public class AdmissionDAO {

    public static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    public static Connection connection = databaseConnection.openDBConnection();
    public static Statement statement;
    public static LocalDate todayDate = LocalDate.now();
    public static ResultSet result;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /* Fetch Patient data with patientID from the database
    *  returns patient record with provided patient ID. */
    public ResultSet getPatient(String patientID)  {

        return result;
    }

    /* Fetch admission type with admissionTypeID from the database.
    *  returns name of Admission type from given ID. */
    public String getAdmissionType(int admissionTypeID)  {
        String admissionType=null;
        return admissionType;
    }

    /* Fetch all the admission types stored in the database.
    *  returns ResultSet object with list of Admission Types from database. */
    public ResultSet getAdmissionTypesList()  {
        return result;
    }

    /* Fetch all the disease list stored in the database.
    *  returns ResultSet object with list of disease from database. */
    public ResultSet getDiseaseList()  {
        return result;
    }

    /* Fetch disease code with diseaseID from the database.
    *  returns Disease code associated with provided disease id. */
    public ResultSet getDisease(int diseaseID)  {
        return result;
    }

    /* Fetch all the doctor list stored in the database.
    *  returns ResultSet object with list of Doctors from database. */
    public ResultSet getDoctorList()  {
        return result;
    }

    /* Fetch doctor code with doctorID from the database.
    *  returns ResultSet object of Doctor associated with provided doctor id. */
    public ResultSet getDoctor(int doctorID)  {
        return result;
    }

    /* Fetch all the ward list stored in the database.
    *  returns ResultSet object with list of wards. */
    public ResultSet getWardsList()  {
        return result;
    }

    /* Fetch Ward code with wardID from the database.
    *  returns Ward name associated with the provided ward id.*/
    public String getWardCode(int wardID) {
        String wardCode = null;
        return wardCode;
    }

    /* Fetch all the available beds with isOccupied = 0 from the database.
    *  returns list of all the available beds as ResultSet object */
   public ResultSet getAvailableBeds()  {
       return result;
    }

    /* Fetch Bed code with bedID from the database.
       returns Bed code associated with bed id. */
    public String getbedCode(int bedID) {
        String bedCode = null;
        return bedCode;
    }

    /* Saves the Admission form data stored in Admission object to the database.
       This method returns 1 if user inserted successfully. */
    public int saveAdmissionForm(Admission admission)  {
        int result = 0;
        return result;
    }

}
