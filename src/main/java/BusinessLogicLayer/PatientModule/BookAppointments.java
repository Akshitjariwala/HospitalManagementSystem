package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookAppointments {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement=null;
    private Scanner readInput=new Scanner(System.in);
    private List<String> doctorList=new ArrayList<>();
    private static List<String> typeOfAppointmenListt= new ArrayList<String>(){{
        add("In Person");add("Online Consultation");
    }};
    private static List<String> timeSlotList= new ArrayList<String>(){{
        add("Morning");add("Afternoon");add("Evening");
    }};
    public boolean appointmentBookingPortalofPatient() {
        String selectedDoctor=null;
        int appointment=0;
        String date=null;
        String timeSlotSelected=null;
        int doctorChoice=0;
        int timeSlotChoice=0;
        System.out.println("==============================\nBOOK APPOINTMENT\n==============================");

        try {
            System.out.println("Fetching details about available Doctors. One Moment .....");
            //TimeUnit.SECONDS.sleep(5);
            String fetchingDoctordetails="SELECT concat('Dr.',first_name,' ', last_name) as doctor_name,specialization,experience_years FROM CSCI5308_6_DEVINT.doctors;";
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(fetchingDoctordetails);

            //print doctor list
            System.out.println("|\tOption\t\t|\t\tDoctor Name\t\t|\tSpecialization\t\t|\tExperience\t\t|");
            System.out.println("---------------------------------------------------------------------------------");
            int optionIndex=0;
            while (resultSet.next()){

                doctorList.add(resultSet.getString(1));
               // System.out.println("|\t"+optionIndex+"\t\t|\t"+resultSet.getString(1)+"\t\t\t|\t"+resultSet.getString(2)+"\t|\t"+resultSet.getDouble(3)+"\t|");
                System.out.println("|\t\t"+ ++optionIndex+"\t\t   "+resultSet.getString(1)+"\t\t\t\t"+resultSet.getString(2)+"\t\t\t\t"+resultSet.getDouble(3)+"\t|");


            }
            System.out.println("\n");


            //Select doctor
            do{
                if(doctorChoice==0 || doctorChoice!=0)
                    System.out.println("*** Please enter correct doctor prefenence ***");

                System.out.println("Select doctor (Option) with whom you want to book an appointment:");
                doctorChoice=readInput.nextInt();
            }while (!(doctorChoice>0  && doctorChoice<doctorList.size()));
            selectedDoctor=doctorList.get(doctorChoice-1);

            System.out.println("\n\nPlease enter below details to book an appoint with "+selectedDoctor.toString()+" :");

            //Select type of appointment
            do{
                if(appointment!=0)
                    System.out.println("*** Please enter correct Appointment Type ***");

                System.out.println("Type of appointment 1)In Person 2) Online Consultation:");
                appointment=readInput.nextInt();
            }while (!(appointment==1 || appointment==2));

            //Date

            //Select Time
            do{
                if(timeSlotChoice!=0)
                    System.out.println("*** Please enter correct Time Slot ***");

                System.out.println("Preferred Time Slot 1)Morning 2) Afternoon 3) Evening:");
                timeSlotChoice=readInput.nextInt();
            }while (!(timeSlotChoice==1 || timeSlotChoice==2 || timeSlotChoice==3));


        databaseConnection.closeDBConnection();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BookAppointments bookAppointments=new BookAppointments();
        bookAppointments.appointmentBookingPortalofPatient();
    }
}
