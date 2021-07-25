package DatabaseLayer.Dao.Interfaces;

import BusinessLogicLayer.BeanClasses.PatientAppointmentWithDoctor;

import java.sql.ResultSet;

public interface IBookAppointmentsDAO {

    String getPatientName(String patientid);
    ResultSet fetchDoctorList();
    boolean saveAppointment(String patient, String doctor, PatientAppointmentWithDoctor appointmentWithDoctor);
    }
