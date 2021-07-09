package BusinessLogicLayer.DoctorModule;

import java.util.Scanner;

public class DoctorHome {
	String docId;
	public DoctorHome(String docId) {
		this.docId=docId;		
	}

	public void doctorHomePage()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("=================================================");
		System.out.println("Welcome Doctor"+"/t"+this.docId);
		System.out.println("=================================================");
		do
		{
			System.out.println("1. View Appointments");
			System.out.println("2. View Patients");
			System.out.println("3. View Reports");
			System.out.println("4. Exit");
			System.out.println("Select a choice between 1-4");
			int choice=sc.nextInt();
			if (choice > 0 && choice <= 4) {
				switch (choice) {
				case 1:	
					System.out.println("Enter appointment status");
					String appointmentstatus=sc.next();
					ViewAppointments v1=new ViewAppointments(this.docId,appointmentstatus);
					boolean flag=v1.viewAllAppointments();
					if(flag==false)
						System.out.println("Please try with a different status");		

					break;
				case 2:
					
					break;
				case 3:
					break;
				case 4:
					System.exit(1);// exit()
					
				}
			} else {
				System.out.printf("%n");
				System.out.println("Invalid Input Received! Please Enter Valid Selection.");
				System.out.printf("%n");
			}




		}while(true);
	}

}
