package BusinessLogicLayer.PatientModule;

import DatabaseLayer.DatabaseConnection.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BookAppointments {

    private static DatabaseConnection databaseConnection = DatabaseConnection.createInstance();
    private static Connection connection = databaseConnection.openDBConnection();
    private Statement statement=null;
    private ResultSet resultSet=null;
    private Scanner readInput=new Scanner(System.in);
    private String selectedDoctor=null;
    private int appointment=0;
    private String date=null;
    private String timeSlotSelected=null;
    private int doctorChoice=0;
    private int timeSlotChoice=0;
    private List<String> doctorList=new ArrayList<>();
    private PatientAppointmentWithDoctor appointmentWithDoctor=new PatientAppointmentWithDoctor();
    private static List<String> typeOfAppointmenList= new ArrayList<String>(){{
        add("In Person");add("Online Consultation");
    }};
    private static List<String> timeSlotList= new ArrayList<String>(){{
        add("Morning");add("Afternoon");add("Evening");
    }};

    public boolean appointmentBookingPortalofPatient(String patientName) {

        System.out.println("==============================\nBOOK APPOINTMENT\n==============================");

        try {
            System.out.println("Fetching details about available Doctors. One Moment .....");
            TimeUnit.SECONDS.sleep(5);
            displayDoctorList();
            System.out.println("\n");

            //Patient
            appointmentWithDoctor.setPatientName(patientName);

            //Select doctor
            Boolean doctorFlag=false;
            do{
                if(doctorChoice!=0 || doctorFlag==true)
                    System.err.println("*** Please enter correct doctor prefenence ***\n");

                System.out.println("Select doctor (Option) with whom you want to book an appointment:");
                doctorChoice=readInput.nextInt();
                doctorFlag=true;
            }while (!(doctorChoice>0  && doctorChoice<doctorList.size()));
                appointmentWithDoctor.setDoctorName(doctorList.get(doctorChoice-1));
            System.out.println("\n\nPlease enter below details to book an appoint with "+appointmentWithDoctor.getDoctorName()+" :");

            //Select type of appointment
            Boolean appointmentFlag=false;
            do{
                if(appointment!=0 || appointmentFlag==true)
                    System.err.println("*** Please enter correct Appointment Type ***\n");

                System.out.println("Type of appointment 1)In Person 2) Online Consultation:");
                appointment=readInput.nextInt();
                appointmentFlag=true;
            }while (!(appointment>0 && appointment<3));
                appointmentWithDoctor.setTypeOfAppointment(typeOfAppointmenList.get(appointment-1));

            //Date
            Boolean dateFlag=false;
            do{
                if(date!=null || dateFlag==true)
                    System.err.println("*** Please enter correct Date of Appointment  ***\n");

                System.out.println("Date (dd/mm/yyyy):");
                date= readInput.next();
                dateFlag=true;
            }while (!date.matches("^(0[1-9]|[12][0-9]|3[01])([./-])(0[1-9]|1[012])([./-])(19|20)\\d\\d$"));
            appointmentWithDoctor.setAppointmentDate(date);

            //Select Time
            do{
                if(timeSlotChoice!=0)
                    System.err.println("*** Please enter correct Time Slot ***\n");

                System.out.println("Preferred Time Slot 1)Morning 2) Afternoon 3) Evening:");
                timeSlotChoice=readInput.nextInt();
            }while (!(timeSlotChoice==1 || timeSlotChoice==2 || timeSlotChoice==3));
                appointmentWithDoctor.setTimeSlot(timeSlotList.get(timeSlotChoice-1));

                displayAppointmentDetails();
            databaseConnection.closeDBConnection();
        }catch (InterruptedException e){
           System.out.println("Time ERROR");
            return false;
        }catch (SQLException e){
            System.err.println("Sql ERROR");
        }
        return true;
    }

    private void displayDoctorList() throws SQLException {
        String fetchingDoctordetails="SELECT concat('Dr.',first_name,' ', last_name) as doctor_name,specialization,experience_years FROM CSCI5308_6_DEVINT.doctors;";
        statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(fetchingDoctordetails);
        //print doctor list
        System.out.println("|\tOption\t\t|\t\tDoctor Name\t\t|\tSpecialization\t\t|\tExperience\t\t|");
        System.out.println("---------------------------------------------------------------------------------");
        int optionIndex=0;
        while (resultSet.next()){

            doctorList.add(resultSet.getString(1));
            System.out.println("|\t\t"+ ++optionIndex+"\t\t   "+resultSet.getString(1)+"\t\t\t\t"+resultSet.getString(2)+"\t\t\t\t"+resultSet.getDouble(3)+"\t|");
        }
    }

    private void displayAppointmentDetails(){
        System.out.println("\nBelow are you appointment Details:\n");
        System.out.println("1. Patient Name: "+appointmentWithDoctor.getPatientName());
        System.out.println("2. Doctor Name: "+appointmentWithDoctor.getDoctorName());
        System.out.println("3. Date of Appointment: "+appointmentWithDoctor.getAppointmentDate());
        System.out.println("4. Preferred Time Slot: "+appointmentWithDoctor.getTimeSlot());
        System.out.println("5. Type of Appointment: "+appointmentWithDoctor.getTypeOfAppointment());
        System.out.println("6. Confirm Appointment");
        System.out.println("7. Main Menu");
        System.out.println("\nTo change any information, please select from 2-5.\nTo confirm appointment select 6 and select 7 to go back to Main Menu");

        changeAppointmentDetails();
    }

    private void changeAppointmentDetails(){
        System.out.println("Enter your choice:");
        int updateChoice=readInput.nextInt();
        try {
            switch (updateChoice) {
                case 2:
                    displayDoctorList();
                    Boolean doctorFlag=false;
                    do{
                        if(doctorChoice!=0 && doctorFlag==true)
                            System.err.println("*** Please enter correct doctor prefenence ***\n");

                        System.out.println("Please enter new doctor: ");
                        doctorChoice=readInput.nextInt();
                        doctorFlag=true;
                    }while (!(doctorChoice>0  && doctorChoice<doctorList.size()));
                    appointmentWithDoctor.setDoctorName(doctorList.get(doctorChoice-1));
                    displayAppointmentDetails();
                    break;

                case 3:

                    Boolean dateFlag=false;
                    do{
                        if(date!=null && dateFlag==true)
                            System.err.println("*** Please enter correct Date of Appointment  ***\n");

                        System.out.println("Please enter new Date: ");
                        date= readInput.next();
                        dateFlag=true;
                    }while (!date.matches("^(0[1-9]|[12][0-9]|3[01])([./-])(0[1-9]|1[012])([./-])(19|20)\\d\\d$"));
                    appointmentWithDoctor.setAppointmentDate(date);
                    displayAppointmentDetails();
                    break;

                case 4:
                    System.out.println("New Time Slot 1)Morning 2) Afternoon 3) Evening:");
                    Boolean timeFlag=false;
                    do{
                        if(timeSlotChoice!=0 && timeFlag==true)
                            System.err.println("*** Please enter correct Time Slot ***\n");

                        System.out.println("Preferred Time Slot:");
                        timeSlotChoice=readInput.nextInt();
                        timeFlag=true;
                    }while (!(timeSlotChoice==1 || timeSlotChoice==2 || timeSlotChoice==3));
                    appointmentWithDoctor.setTimeSlot(timeSlotList.get(timeSlotChoice-1));
                    displayAppointmentDetails();
                    break;

                case 5:
                    System.out.println("Type of appointment 1)In Person 2) Online Consultation:");
                    Boolean appointmentFlag=false;
                    do{
                        if(appointment!=0 && appointmentFlag==true)
                            System.err.println("*** Please enter correct Appointment Type ***\n");

                        System.out.println("Change Appointment Type: ");
                        appointment=readInput.nextInt();
                        appointmentFlag=true;
                    }while (!(appointment>0 && appointment<3));
                    appointmentWithDoctor.setTypeOfAppointment(typeOfAppointmenList.get(appointment-1));
                    displayAppointmentDetails();
                    break;

                case 6:
                    saveAppointment(appointmentWithDoctor.getPatientName(),appointmentWithDoctor.getDoctorName());
                    break;

                default:
                    System.err.println("Wrong Input");
                    changeAppointmentDetails();
                    break;
            }
        }
        catch (SQLException E){
            System.err.println("SQL ERROR !!!");
        }
    }

    private void saveAppointment(String patient,String doctor){

        String patient_id="";
        String doctor_id="";
        String appointmentStatus="PENDING";
        try {
            statement=connection.createStatement();
            String querytoFindID="Select dr.doc_id,pt.patient_id from doctors dr join patients pt " +
                    " where concat(\"Dr.\",dr.first_name,\" \",dr.last_name)='"+doctor+"'" +
                    " AND concat(pt.first_name,\" \",pt.last_name)='"+patient+"';";
            resultSet= statement.executeQuery(querytoFindID);

            while (resultSet.next()){
                doctor_id=resultSet.getString(1);
                patient_id=resultSet.getString(2);
            }
            System.out.println(doctor_id+":"+patient_id);
            String queryToSaveAppointment="INSERT INTO appointments (patient_id, doc_id, appointment_date, preferred_slot, type_of_appo, appointment_status) \n" +
                    "VALUES ('"+patient_id+"','"+doctor_id+"','"+appointmentWithDoctor.getAppointmentDate()+"','"+appointmentWithDoctor.getTimeSlot()+"','"+appointmentWithDoctor.getTypeOfAppointment()+"','"+appointmentStatus+"');";

            int tempResultSet=statement.executeUpdate(queryToSaveAppointment);
        }catch (SQLException e){
            System.err.println("SQL ERROR");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        BookAppointments bookAppointments=new BookAppointments();
        bookAppointments.appointmentBookingPortalofPatient("jash kuon");
    }
}
