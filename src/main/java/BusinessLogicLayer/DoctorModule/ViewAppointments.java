package BusinessLogicLayer.DoctorModule;

import java.util.ArrayList;

import DatabaseLayer.Dao.ViewAppointmentsDao;
import BusinessLogicLayer.AdminModule.Appointment;

public class ViewAppointments {
	String docId;
	String status;
	ViewAppointmentsDao vdao;
	public ViewAppointments(String docId,String status)
	{
		this.docId=docId;
		this.status=status;
		vdao=new ViewAppointmentsDao();

	}
	
	  public boolean viewAllAppointments() {
		// TODO Auto-generated method stub
		ArrayList<Appointment> appointments=new ArrayList<Appointment>();
		appointments=vdao.getAppointmentList(this.docId,status);
		System.out.println("=================================================");
		System.out.println("\t\t\t\tYour appointments\t\t\t\t");
		System.out.println("=================================================");
		System.out.println("\t\t\t\t"+this.status+"\t\t\t\t");
		if(appointments.size()>0)
		{
			for(Appointment a:appointments) {
				System.out.printf("%-10s %-10s %-10s",a.getAppointmentId(),"|",a.getPatientId());
				System.out.printf("%-10s %-10s %-10s %-10s %-10s%n",a.getDate(),"|",a.getPreferredSlot(),"|",a.getPreferredSlot());
			}
			System.out.printf("%n");

			return true;
		}
		else		{
			System.out.println("No appointments of "+this.status+ "status for you");
			return false;
		}
	}




}
