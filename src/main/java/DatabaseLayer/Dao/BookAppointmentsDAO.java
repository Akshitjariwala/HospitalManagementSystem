package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.PatientAppointmentWithDoctor;
import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookAppointmentsDAO {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Statement statement = null;
    private ResultSet resultSet = null;

    public String getPatientName(String patientid) {
        String patientName="";
        try {
            statement = connection.createStatement();
            String queryToGetPatientName = "SELECT concat(first_name,' ',last_name) FROM patients where patient_id='" + patientid + "';";
            resultSet = statement.executeQuery(queryToGetPatientName);
            while (resultSet.next()) {
               patientName=resultSet.getString(1);
            }
        }catch (SQLException e) {
            System.err.println("Sql ERROR");
        }
        return patientName;
    }

    public ResultSet fetchDoctorList()  {
        try {
            String fetchingDoctordetails = "SELECT concat('Dr.',first_name,' ', last_name) as doctor_name,specialization,experience_years FROM doctors;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(fetchingDoctordetails);
        }catch (SQLException SQL){
            System.err.println("SQL ERROR");
        }
        return resultSet;
    }

    public boolean saveAppointment(String patient, String doctor, PatientAppointmentWithDoctor appointmentWithDoctor)  {
        String patient_id = patient;
        int doctor_id = 0;
        String appointmentStatus = "PENDING";
        try {
            statement = connection.createStatement();
            String querytoFindID = "Select dr.id from doctors dr " +
                    " where concat('Dr.',dr.first_name,' ',dr.last_name)='" + doctor + "';";

            resultSet = statement.executeQuery(querytoFindID);

            while (resultSet.next()) {
                doctor_id = resultSet.getInt(1);
            }

            String queryToSaveAppointment = "INSERT INTO appointments (patient_id, doc_id, appointment_date, preferred_slot, type_of_appo, appointment_status) \n" +
                    "VALUES ('" + patient_id + "','" + doctor_id + "','" + appointmentWithDoctor.getAppointmentDate() + "','" + appointmentWithDoctor.getTimeSlot() + "','" + appointmentWithDoctor.getTypeOfAppointment() + "','" + appointmentStatus + "');";
       //     int result1=statement.executeUpdate(queryToSaveAppointment);

            String querytoCheckEntry="SELECT * from patients_doctors_mapping WHERE patient_id='"+patient_id+"' " +
                    "AND doc_id='"+doctor_id+"';";

            ResultSet tempResultSet= statement.executeQuery(querytoCheckEntry);
            if (!(tempResultSet.getRow()>0)){
                String queryToMapPatientWithDoctor = "INSERT INTO patients_doctors_mapping (patient_id, doc_id) \n" +
                        "VALUES ('" + patient_id + "','" + doctor_id + "');";
                statement.addBatch(queryToMapPatientWithDoctor);
            }

            statement.addBatch(queryToSaveAppointment);
            int[] tempResult = statement.executeBatch();
        }catch (SQLException e) {
            System.err.println("New APPOINTMENT FAILED TO SAVE");
            e.printStackTrace();
            return  false;
        }
        return true;
    }
}
