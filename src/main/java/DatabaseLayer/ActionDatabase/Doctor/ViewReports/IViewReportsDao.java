package DatabaseLayer.ActionDatabase.Doctor.ViewReports;

import java.util.List;

import BusinessLogicLayer.BeanClasses.Reports;

public interface IViewReportsDao {
	List<Reports> getAllReports(int docId);
	List<Reports> getPatientReports(int docId, String patientId);
}
