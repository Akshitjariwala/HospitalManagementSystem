package DatabaseLayer.Dao;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Reports;

public interface IViewReportsDao {
	List<Reports> getAllReports(int docId);
	List<Reports> getPatientReports(int docId, String patientId);
}
