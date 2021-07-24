package DatabaseLayer.Dao;

import BusinessLogicLayer.BeanClasses.Admission;

import java.sql.SQLException;

public interface IAdmissionDetailsDAO {
    Admission getAdmissionDetails(String patientID) throws SQLException;
}
