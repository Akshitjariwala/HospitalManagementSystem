package BusinessLogicLayer.DoctorModule;

import java.util.ArrayList;

import BusinessLogicLayer.BeanClasses.Reports;
import DatabaseLayer.Dao.ViewReportsDao;

public class ViewReports {

	String docId;
	ViewReportsDao vrdao;
	public ViewReports(String docId) {
		// TODO Auto-generated constructor stub
		this.docId=docId;
		vrdao=new ViewReportsDao();		
	}
	public boolean viewAllReports() {
		// TODO Auto-generated method stub
		ArrayList<Reports> reports=new ArrayList<Reports>();
		reports=vrdao.getAllReports(this.docId);
		if(reports==null)
			return false;
		if(reports!=null && reports.size()>0) {
			System.out.println("================================================================");
			System.out.println("\t\t\t\tAll Reports under your supervision\t\t\t\t");
			System.out.println("================================================================");
			System.out.printf("%n");
			System.out.printf("%-10s %-10s %-20s", "Report Id", " | ", "PatientID");
			System.out.printf("%-20s %-10s %-20s", "Diagnosis Name", " | ", "Report Date");
			System.out.printf("%-50s %-10s %-30s", "Result", " | ", "Report Type");
			for(Reports report:reports)
			{
				System.out.printf("%-10s %-10s %-20s", report.getReportId(), " | ", report.getPatientId());
				System.out.printf("%-20s %-10s %-20s", report.getDiagnosisName(), " | ", report.getDate());
				System.out.printf("%-50s %-10s %-30s", report.getTestResult(), " | ",report.getTestType());
			}
			return true;
		}
		else {
			System.out.println("==================================================");
			System.out.println("\t\tCurrently no reports for patients under your supervision\t\t");
			System.out.println("==================================================");
			return false;
		}
}

public boolean viewPatientReports() {
	// TODO Auto-generated method stub
	return false;
}

}
